package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


/**
 * Get another stream from an iterator stream item
 * Получить из элемента потока итераторов другой поток
 * 5.1.4. Создать convert(Iterator<Iterator>) [#293771]
 */

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> it;
    private T t;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (data.hasNext()) {
            while (data.next().hasNext()) {
            }
        }
        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return it.next();
    }
}


/* так делать нельзя

    private List<T> temp = new ArrayList<>();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
        while (data.hasNext()) {
            Iterator<T> inner = data.next();
            while (inner.hasNext()) {
                temp.add(inner.next());
            }
        }
    }
*/