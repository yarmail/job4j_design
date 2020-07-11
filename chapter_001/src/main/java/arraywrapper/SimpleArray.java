package arraywrapper;
import java.util.*;


/**
 * Simple implementation of ArrayList
 * Простая реализация ArrayList
 * 1. Динамический список на массиве. [#293763]
 * В отличие от ArrayWrapper добавляем сюда
 * реализацию fail-fast поведения
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] elementData = new Object[1];
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
     * Если в массиве не хватает места, добавляем объем
     * Размер массива нужно увеличить как минимум в два раза,
     * потому что это тяжелая операция
     * Упрощенная форма grow() из ArrayList
     */
    private void grow() {
        this.elementData = Arrays.copyOf(this.elementData, this.elementData.length * 2);
    }

    public void add(T value) {
        if (size == elementData.length - 1) {
            grow();
        }
        elementData[size] = value;
        size++;
        modCount++;
    }

    public void set(int index, T value) {
        Objects.checkIndex(index, size);
        elementData[index] = value;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(elementData, index + 1, elementData, index, elementData.length - index - 1);
        elementData[size - 1] = null;
        size--;
        modCount++;
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
                return (T) elementData[cursor++];
            }
        };
    }
}
