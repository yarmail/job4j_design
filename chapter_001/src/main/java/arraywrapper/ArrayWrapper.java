package arraywrapper;

import java.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Need to make a wrapper over the array
 * Необходимо сделать обертку над массивом
 * 5.2.1. Реализовать SimpleArray<T> [#156]
 */
public class ArrayWrapper<T> implements Iterator<T> {

    private Object[] array;
    private int position = 0;
    private int pointer = 0;

    /**
     * Конструктор инициализирует
     * структуру и задает ей размер
     * указанный пользователем
     */
    public ArrayWrapper(int size) {
        this.array = new Object[size];
    }

    /**
     * Если в массиве не хватает места, добавляем объем
     * Размер массива нужно увеличить как минимум в два раза,
     * потому что это тяжелая операция
     */
    private void addVolumeToArray() {
        this.array = Arrays.copyOf(this.array, this.array.length * 2);
    }

    public void add(T value) {
        if (position == array.length - 1) {
            addVolumeToArray();
        }
        array[position++] = value;
    }

    public void set(int index, T value) {
        Objects.checkIndex(index, position);
        array[index] = value;
    }

    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) array[index];
    }

    public void remove(int index) {
        Objects.checkIndex(index, position);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[position - 1] = null;
        position--;
        }

    @Override
    public boolean hasNext() {
        return pointer < position;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) array[pointer++];
    }
}