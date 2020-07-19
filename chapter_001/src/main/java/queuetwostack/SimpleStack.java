package queuetwostack;

public class SimpleStack<T> {
    private ForwardLinked<T> list = new ForwardLinked<>();
    private int elementcount = 0;

    /**
     * Элемент добавляется в стек последним (наверх)
     */
    public void push(T value) {
        list.addLast(value);
        elementcount++;
    }
    /**
     * Извлечение данных из стека.
     * Извлекается и возвращается самый верхний последний элемент
     * и удаляется из стека
     */
    public T pop() {
        elementcount--;
        return list.removeLast();
    }

    public boolean isEmpty() {
        return elementcount == 0;
    }
}