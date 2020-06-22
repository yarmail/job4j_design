package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Create an even number iterator
 * 5.1.2. Создать итератор четных чисел [#293770]
 */
public class IterEven implements Iterator<Integer> {
    private final int[] data;
    private int pointer = 0;
    private int iCurrent = -1;


    public IterEven(int[] data) {
        this.data = data;
    }

    boolean isEven(int pointer) {
        return data[pointer] % 2 == 0;
    }

    /**
     * Проверка и возврат интексов четных чисел,
     * если они есть
     */
    private int iNextEven(int pointer) {
        int  iNextEven = -1;
        for (int i = pointer; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                iNextEven = i;
                break;
            }
        }
        return iNextEven;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;

        if (iNextEven(this.pointer) != -1) {
            pointer = iNextEven(this.pointer);
        }
        if (iNextEven(this.pointer) != -1) {
            result = true;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = data[pointer];
        pointer++;
        return result;
    }
}