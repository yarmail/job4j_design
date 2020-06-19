package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterMatrix implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public IterMatrix(int[][] data) {
        this.data = data;
    }

    /**
     * Есть ли следующий элемент в массиве
     * если индекс текущей строки не выходит за пределы
     * общего количества строк, но в ней нет элементов
     * (занятых столбцов) ...
     */
    @Override
    public boolean hasNext() {
        while (row < data.length && data[row].length == 0) {
            row++;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = data[row][column++];
        if (column > data[row].length - 1) {
            row++;
            column = 0;
        }
        return result;
    }
}
