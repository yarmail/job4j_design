package linkedforward;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Тестовый класс для ForwardLinked.java
 * Проверяем только метод удаления
 */
public class DeleteFirstLinkedTest {

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addLast(1);
        linked.removeFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.removeFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addLast(1);
        linked.addLast(2);
        linked.removeFirst();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }
}