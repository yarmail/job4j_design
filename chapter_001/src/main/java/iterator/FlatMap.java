package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Get another stream from an iterator stream item
 * Получить из элемента потока итераторов другой поток
 * 5.1.4. Создать convert(Iterator<Iterator>) [#293771]
 */

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> iter;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        // первичная инициализация iter
        if (data.hasNext() && iter == null) {
            iter = data.next();
        }
        while (iter != null && data.hasNext() && !iter.hasNext()) {
            iter = data.next();
        }
        return iter.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iter.next();
    }
}


/* Ещё вариант
private Iterator<Integer> current = Colections.emptyIterator();
@Override
    public boolean hasNext() {
        while (its.hasNext()) && !corrent.hasNext()) {
        corrent = its.next();
        }
        return !corrent.hasNext()
    }
    ...

 */

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