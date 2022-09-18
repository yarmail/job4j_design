package assertjon;

import java.util.Iterator;

/**
 * Подключение библиотеки AssertJ [#504881]
 *
 * (есть тесты)
 */
public class ArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public ArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        return data[point++];
    }
}