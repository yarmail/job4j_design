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


    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        // пока есть следующий элемент
        while (data.hasNext()) {
            //пока у этого элемента есть составляющие
            while (data.next().hasNext()) {
                data.next().next();
                result = true;
            }
            data.next();

        }
        return result;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data.next().next();
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