package iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Create an iterator for a one-dimensional array of numbers
 * Создать итератор для одномерного массива чисел
 * Итератор должен отдавать элементы в обратном порядке
 *
 * из темы итератор [#293772]
 */
public class IterArrayReverse implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public IterArrayReverse(int[] data) {
        this.data = data;
        this.point = data.length - 1;
    }

  @Override
    public boolean hasNext() {
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}
