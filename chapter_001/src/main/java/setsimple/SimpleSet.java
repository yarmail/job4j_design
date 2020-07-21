package setsimple;

import arraywrapper.SimpleArray;
import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> simpleArrayList = new SimpleArray<>();

    /**
     * Проверки
     * на null в коллекции
     * на null элемент
     * на одинаковые элементы
     *
     */
    private boolean check(T value) {
        boolean result = false;
        for (T i : simpleArrayList) {
            if (value == null) {
                result = true;
                break;
            }
            if (i == null) {
                result = true;
                break;
            }
            if (i.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void add(T value) {
        if (!check(value)) {
            simpleArrayList.add(value);
        }
    }


    @Override
    public  Iterator<T> iterator() {
        return simpleArrayList.iterator();
    }
}