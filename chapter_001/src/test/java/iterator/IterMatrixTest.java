package iterator;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.NoSuchElementException;

public class IterMatrixTest {

    @Test
    public void whenOnlyOneElement() {
        int[][] in = {
                {1}
        };
        IterMatrix it = new IterMatrix(in);
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenFirstEmptyThenNext() {
        int[][] in = {
                {}, {1}
        };
        IterMatrix it = new IterMatrix(in);
        System.out.println(Arrays.toString(in[1]));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenFirstEmptyThenHashNext() {
        int[][] in = {
                {}, {1}
        };
        IterMatrix it = new IterMatrix(in);
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenRowHasDiffSize() {
        int[][] in = {
                {1}, {2, 3}
        };
        IterMatrix it = new IterMatrix(in);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenFewEmpty() {
        int[][] in = {
                {1}, {}, {}, {}, {2}
        };
        IterMatrix it = new IterMatrix(in);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenEmpty() {
        int[][] in = {
                {}
        };
        IterMatrix it = new IterMatrix(in);
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyThenNext() {
        int[][] in = {
                {}
        };
        IterMatrix it = new IterMatrix(in);
        it.next();
    }

    @Test
    public void whenMultiHashNext() {
        int[][] in = {
                {}, {1}
        };
        IterMatrix it = new IterMatrix(in);
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }
}