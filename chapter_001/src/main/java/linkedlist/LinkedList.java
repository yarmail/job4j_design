package linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple implementation of LinkedList
 * простая реализация LinkedList
 * 2. Создать контейнер на базе связанного списка [#293764]:
 * 1) add(E value); (добавляет в конец)
 * 2) E get(int index);
 * 3) реализовать интерфейс Iterable<E>.
 */

public class LinkedList<T> implements Iterable<T> {

    /**
     * size - общее количество ненулевых элементов
     */
    private int size = 0;

    /**
     * modCount - ConcurrentModification
     * индикатор изменений для итератора
     */
    private int modCount = 0;
    /**
     * Указатель на первый элемент (узел)
     * Начало списка
     */
    private Node<T> first;
    /**
     * Указатель на последний элемент (узел)
     * Конец списка
     */
    private Node<T> last;

    /**
     * Для установки ссылок на предыдущий и следующий
     * элементы LinkedList использует объекты своего
     * вложенного класса Node:
     */
    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
        public T getData() {
            return item;
        }
    }

    /**
     * Метод добавляет элемент в конец списка
     *
     */
    public void addLast(T e) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            // если нет следующего элемента, значит это первый?
            first = newNode;
        } else {
            // если есть следующий элемент, то от него даем ссылку на новый
            l.next = newNode;
        }
        size++;
        modCount++;
    }
    /**
     * Метод получения элемента по индексу.
     */
    public T get(int index) {
        Node<T> result = this.first;
        if (result == null) {
            throw new NoSuchElementException();
        }
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }
    /**
     * Iterator<T> iterator();
     * метод iterator() реализует интерфейс Iterable
     * переопределяя итератор, в котором, в свою очередь,
     * переопределяются его методы
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            private int expectedModCount = modCount;

            private void checkForComodification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            Node<T> temp = first;

            @Override
            public boolean hasNext() {
                checkForComodification();
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = temp.getData();
                temp = temp.next;
                cursor++;
                return value;
            }
        };
    }
}
