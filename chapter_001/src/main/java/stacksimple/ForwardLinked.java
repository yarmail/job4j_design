package stacksimple;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void addLast(T value) {
        Node<T> node = new Node<T>(value, null);
        //если списка нет, созданный элемент будет head
        if (head == null) {
            head = node;
            return; //аналог break?
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        head = node.next;
        node.next = null;
        return node.value;
    }

    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        if (node.next == null) {
            head = null;
        }
        Node<T> prev = node;
         while (node.next != null) {
             prev = node;
             node = node.next;
        }
        T result = node.value;
        prev.next = null;
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
