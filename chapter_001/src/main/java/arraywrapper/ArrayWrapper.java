package arraywrapper;

import java.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Need to make a wrapper over the array
 * Необходимо сделать обертку над массивом
 * 5.2.1. Реализовать SimpleArray<T> [#156]
 * (вероятно похожую на ArrayList)
 */
public class ArrayWrapper<T> implements Iterable<T> {

    private Object[] elementData;
    private int position = 0;

    /**
     * Конструктор инициализирует
     * структуру и задает ей размер
     * указанный пользователем
     */
    public ArrayWrapper(int size) {
        this.elementData = new Object[size];
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
        if (position == elementData.length - 1) {
            grow();
        }
        elementData[position++] = value;
    }

    public void set(int index, T value) {
        Objects.checkIndex(index, position);
        elementData[index] = value;
    }

    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) elementData[index];
    }

    public void remove(int index) {
        Objects.checkIndex(index, position);
        System.arraycopy(elementData, index + 1, elementData, index, elementData.length - index - 1);
        elementData[position - 1] = null;
        position--;
    }

    /**
     * Iterator<T> iterator();
     * метод iterator() реализует интерфейс Iterable
     * переопределяя итератор, в котором, в совю очередь
     * переопределяются его методы
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pointer = 0;

            @Override
            public boolean hasNext() {
                return pointer < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elementData[pointer++];
            }
        };
    }
}