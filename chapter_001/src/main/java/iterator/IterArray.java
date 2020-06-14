package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Create an iterator for a one-dimensional array of numbers
 * Создать итератор для одномерного массива чисел
 *
 * из темы итератор [#293772]
 */
public class IterArray implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public IterArray(int[] data) {
        this.data = data;
    }

    /**
     * Двигаться, пока point < data.length ?
     *
     */
    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    /**
     * point как указатель массива
     * и движение от 0 направо
     *
     * Что будет, если в итераторе
     * нет элементов и мы вызовем метод next?
     *
     * В этом случае итератор должен сгенерировать
     * исключение NoSuchElementException.
     * Поправим метод next. Сделаем вызов метода
     * hasNext и если элементов нет, то выкинем исключение.
     * (без него программа выкенет другое исключение
     * (ArrayIndexOutOfBoundsException))
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
