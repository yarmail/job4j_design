package queuetwostack;


import java.util.NoSuchElementException;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleQueueTest {
    @Test
    public void whenPushPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        int rsl = queue.pop();
        assertThat(rsl, is(1));
    }

    @Test
    public void when2PushPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        int rsl = queue.pop();
        assertThat(rsl, is(1));
    }

    @Test
    public void when2PushPopPushPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.pop();
        queue.push(2);
        int rsl = queue.pop();
        assertThat(rsl, is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.pop();
    }
}