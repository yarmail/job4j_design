package linkedforward;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    /**
     * подготовка к стеку - метод push
     *
     */
    public void addLast(T value) {
        Node<T> node = new Node<T>(value, null);
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

    /**
     * Подгтовка к стеку - метод poll
     *
     */
    public T removeFirst() {
        Node<T> node = head;
        if (node == null) {
            throw new NoSuchElementException();
        }
        head = node.next;
        node.next = null;
        return node.value;
    }

    /**
     * Подготовка к стеку - метод pop
     *
     */
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

    /**
     * Дополнительное задание
     * 6. Перевернуть связанный список [#293766]
     * (односвязный)
     */
    public void revert() {
        Node<T> temp = head;
        Node<T> previous = null;
        Node<T> current = null;
        while (temp != null) {
            current = temp;
            temp = temp.next;
            current.next = previous;
            previous = current;
            head = current;
        }
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
