package setsimple;

import arraywrapper.SimpleArray;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> simpleArrayList = new SimpleArray<>();

    private boolean check(T value) {
        boolean result = false;
        for (T i : simpleArrayList) {
            if (Objects.equals(i, value)) {
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