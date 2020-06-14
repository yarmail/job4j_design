package iterator;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.NoSuchElementException;


public class IterArrayTest {

    /**
     * Проверяем hasNext
     * Когда несколько вызовов метода  - все успешно
     * (есть ли следующие элементы)
     */
    @Test
    public void whenMultiCallhasNextThenTrue() {
        IterArray it = new IterArray(
                new int[] {1, 2, 3}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    /**
     * Проверяем next
     * Когда читаем последовательность индексов
     * Проверяем значения
     *
     */
    @Test
    public void whenReadSequence() {
        IterArray it = new IterArray(
                new int[] {1, 2, 3}
        );
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    /**
     *  Валидация метода next()
     * Что будет, если в итераторе
     * нет элементов и мы вызовем метод next?
     *
     * В этом случае итератор должен сгенерировать
     * исключение NoSuchElementException.
     * Поправим метод next. Сделаем вызов метода
     * hasNext и если элементов нет, то выкинем исключение.
     * (без него программа выкенет другое исключение
     * (ArrayIndexOutOfBoundsException))
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        IterArray it = new IterArray(
                new int[] {}
        );
        it.next();
    }
}