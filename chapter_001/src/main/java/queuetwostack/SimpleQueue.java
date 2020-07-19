package queuetwostack;

public class SimpleQueue<T> {
    private SimpleStack<T> in = new SimpleStack<>();
    private SimpleStack<T> out = new SimpleStack<>();

    public void push(T value) {
        in.push(value);
    }

    public T pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
        }
    }