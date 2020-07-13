package linkedlist;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class LinkedListTest {

    @Test
    public void whenAddLastThenGet() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("first");
        String rsl = list.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddLastThenIt() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("first");
        String rsl = list.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmpty() {
        LinkedList<String> list = new LinkedList<>();
        list.get(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        LinkedList<String> list = new LinkedList<>();
        list.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("first");
        Iterator<String> it = list.iterator();
        list.addLast("second");
        it.next();
    }

}