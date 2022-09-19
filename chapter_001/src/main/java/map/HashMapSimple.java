package map;

import java.util.*;

/**
 * Implement a simplified HashMap
 * Реализовать упрощенный вариант HashMap
 * boolean insert(K key, V value);
 * V get(K key);
 * boolean delete(K key);
 *
 * 8. Реализовать собственную структуру данных - HashMap [#293793]
 *
 * Реализовывать итератор.
 *
 * Внутренняя реализация должна использовать массив.
 * Нужно обеспечить фиксированное время вставки и получения.
 * Предусмотрите возможность роста хэш-таблицы
 * при нехватке места для нового элемента.
 *
 * Методы разрешения коллизий реализовывать не надо.
 * Например: если при добавлении ключ уже есть,
 * то возвращать false.
 *
 */
public class HashMapSimple<K, V> implements Iterable<HashMapSimple.Node<K, V>> {
    /**
     * Начальный массив должен быть степенью двойки
     */
    private Node<K, V>[] hashTable = new Node[16]; //структура Node ниже
    /**
     * The load factor used when none specified in constructor.
     * Коэффициент загрузки используется, когда ничего не указано в конструкторе.
     */
    private static final float LOAD_FACTOR = 0.75f;
    /**
     * Порог, при котором нужно увеличивать размер массива
     */
    private float threshold = hashTable.length * LOAD_FACTOR;
    /**
     * The number of key-value mappings contained in this map.
     * Количество отображений ключ-значение, содержащихся в этой карте.
     * количество заполненных ячеек массива
     */
    private transient int size = 0;
    /**
     * The number of times this HashMap has been structurally modified
     * Structural modifications are those that change the number of mappings in
     * the HashMap or otherwise modify its internal structure (e.g.,
     * rehash).  This field is used to make iterators on Collection-views of
     * the HashMap fail-fast.  (See ConcurrentModificationException).
     * ---
     * Количество раз, когда этот HashMap был структурно изменен
     * Структурными модификациями являются те, которые изменяют
     * количество отображений в HashMap или иным образом изменить
     * его внутреннюю структуру (например, Перехеширование).
     * Это поле используется для создания итераторов в коллекциях
     * HashMap отказоустойчивый. (См. ConcurrentModificationException).
     * --
     * счетчик изменений
     */
    private transient int modCount = 0;

    /**
     * Вставка объекта
     * В данном случае, если возникает коллизия, просто возвращаем false
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        if (size >= threshold) {
            grow();
        }
        int index = indexFor(hashKey(key));
        if (hashTable[index] == null) {
            hashTable[index] = new Node<>(key, value);
            result = true;
            size++;
            modCount++;
        }
        return result;
    }

    /**
     *
     * Примечание: В методе get(), NPE падает,
     * потому что вы вызываете key, у null.
     * Нужно предварительно делать проверку на null
     *
     */
    public V get(K key) {
        int index;
        V result = null;
        if (key != null) {
            index = indexFor(hashKey(key));
            if (hashTable[index] != null
                    && Objects.equals(key, hashTable[index].key)) {
                result = hashTable[index].value;
            }
        }
        return result;
    }

    public boolean delete(K key) {
        int index;
        boolean result = false;
        if (key != null) {
            index = indexFor(hashKey(key));
            if (hashTable[index] != null
                    && Objects.equals(key, hashTable[index].key)) {
                hashTable[index] = null;
                size--;
                modCount++;
                result = true;
            }
        }
        return result;
    }

    /**
     * Расширение массива по необходимости в 2 раза
     * При этом нужно учесть, что потребуется
     * новое перераспределение всех элементов
     * по массиву новой длины
     */
    private void grow() {
        Node<K, V>[] oldHashTable = hashTable;
        int oldSize = oldHashTable.length;
        hashTable = new Node[oldSize * 2];
        threshold = hashTable.length * LOAD_FACTOR;

        for (int i = 0; i < oldSize; i++) {
            if (oldHashTable[i] != null) {
                K key = oldHashTable[i].getKey();
                int indexNew = indexFor(hashKey(key));
                hashTable[indexNew] = oldHashTable[i];
            }
        }
    }

    /**
     * Расчет индекса (позиции) в массиве
     */
    private int indexFor(int hash) {
        return hash & (hashTable.length - 1);
    }

    /**
     * Метод для работы с ключом, который позволяет сделать довольно редкий hash
     * Здесь hashcode берется почему-то java.lang.object
     */
    private int hashKey(K key) {
        int h;
        if (key == null) {
            h = 0;
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        return h;
    }

/////////////////////////////////////////////// Структура узла

    public static class Node<K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key)
                    && Objects.equals(value, node.value);
        }

        /**
         * Взято из hashmap JDK 14
         *
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

/////////////////////////////////////// Итератор

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private int cursor = 0;
            private int expectedModCount = modCount;

            private void checkForComodification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                checkForComodification();
                while (hashTable[cursor] == null
                        && cursor < hashTable.length - 1) {
                    cursor++;
                }
                return hashTable[cursor] != null;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return hashTable[cursor++];
            }
        };
    }
}
