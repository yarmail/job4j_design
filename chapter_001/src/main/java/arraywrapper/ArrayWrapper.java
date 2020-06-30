package arraywrapper;

import java.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Need to make a wrapper over the array
 * Необходимо сделать обертку над массивом
 * 5.2.1. Реализовать SimpleArray<T> [#156]
 *  Для проверки индекса используйте метод Objects.checkIndex
 *  В методах, где используется индекс нужно делать валидацию.
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
     */
    private void addVolumeToArray() {

        this.array = Arrays.copyOf(this.array, this.array.length + 1);

    }

    public void add(T value) {
        try {
            Objects.checkIndex(position, array.length);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("не хватило места, расширяем массив");
            addVolumeToArray();
        } finally {
            this.array[position] = value;
            position++;
        }
    }

    public void set(int index, T value) {
        boolean invalid = false;
        try {
            Objects.checkIndex(index, array.length);
        } catch (IndexOutOfBoundsException e) {
            invalid = true;
            System.out.println("индекс задан неверно");
            // не знаю, что дальше с этим делать
        }
        if (!invalid) {
            array[index] = value;
        }
    }

    public T get(int index) {
        boolean invalid = false;
        T result = null;
        try {
            Objects.checkIndex(index, array.length);
        } catch (IndexOutOfBoundsException e) {
            invalid = true;
            System.out.println("индекс задан неверно");
            // не знаю, что дальше с этим делать
        }
        if (!invalid) {
            result = (T) array[position];
        }
        return result;
    }

    public void remove(int index) {
        boolean invalid = false;
        try {
            Objects.checkIndex(index, array.length);
        } catch (IndexOutOfBoundsException e) {
            invalid = true;
            System.out.println("индекс задан неверно");
            // не знаю, что дальше с этим делать
        }
        if (!invalid) {
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            array[position - 1] = null;
            position--;
        }

    }

    @Override
    public boolean hasNext() {
        return pointer < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) array[pointer++];
    }
}