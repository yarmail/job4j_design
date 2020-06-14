package iterator;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.NoSuchElementException;


public class IterArrayReverseTest {

    @Test
    public void whenMultiCallhasNextThenTrue() {
        IterArrayReverse it = new IterArrayReverse(
                new int[] {1, 2, 3}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        IterArrayReverse it = new IterArrayReverse(
                new int[] {1, 2, 3}
        );
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        IterArray it = new IterArray(
                new int[] {}
        );
        it.next();
    }
}