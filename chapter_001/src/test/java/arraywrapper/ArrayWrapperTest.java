package arraywrapper;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.NoSuchElementException;

public class ArrayWrapperTest {
    @Test
    public void addAndGet() {
        ArrayWrapper<Integer> intArray = new ArrayWrapper<>(1);
        intArray.add(123);
        Integer expected = 123;
        Integer result = intArray.get(0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSetElementShouldGetSomeElement() {
        ArrayWrapper<Integer> intArray = new ArrayWrapper<>(2);
        intArray.add(123);
        intArray.add(456);
        Integer expected = 789;
        intArray.set(0, expected);
        assertThat(intArray.get(0), is(expected));
    }

    @Test
    public void addAndRemove() {
        ArrayWrapper<Integer> intArray = new ArrayWrapper<>(5);
        intArray.add(123);
        intArray.add(456);
        intArray.add(789);
        intArray.remove(0);
        Integer expected = 456;
        assertThat(intArray.get(0), is(expected));
    }

    @Test
    public void whenAddAndGetUsingNext() {
        ArrayWrapper<Integer> intArray = new ArrayWrapper<>(2);
        intArray.add(123);
        intArray.add(456);
        assertThat(intArray.next(), is(123));
        assertThat(intArray.next(), is(456));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetByIndexGreaterThenSizeShouldException() {
        ArrayWrapper<Integer> intArray = new ArrayWrapper<>(3);
        intArray.set(5, 123);
    }


    @Test(expected = NoSuchElementException.class)
    public void nextIsException() {
        ArrayWrapper<Integer> intArray = new ArrayWrapper<>(3);
        intArray.add(123);
        intArray.add(456);
        intArray.next();
        intArray.next();
        intArray.next();
    }
}