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
     * modCount - ConcurrentModification
     * индикатор изменений для итератора
     */
    private int sizeAndModCount = 0;

    public SimpleArray() {
    }

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
        if (sizeAndModCount == elementData.length - 1) {
            grow();
        }
        elementData[sizeAndModCount++] = value;
    }

    public void set(int index, T value) {
        Objects.checkIndex(index, sizeAndModCount);
        elementData[index] = value;
    }

    public T get(int index) {
        Objects.checkIndex(index, sizeAndModCount);
        return (T) elementData[index];
    }

    public void remove(int index) {
        Objects.checkIndex(index, sizeAndModCount);
        System.arraycopy(elementData, index + 1, elementData, index, elementData.length - index - 1);
        elementData[sizeAndModCount - 1] = null;
        sizeAndModCount--;
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
            private int expectedModCount = sizeAndModCount;

            private void checkForComodification() {
                if (expectedModCount != sizeAndModCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                checkForComodification();
                return cursor < sizeAndModCount;
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
