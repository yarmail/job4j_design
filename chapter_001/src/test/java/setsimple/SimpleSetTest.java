package setsimple;

import java.util.Iterator;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {

    /**
     * Проверяем метод add,
     * чтобы не было одинаковых элементов
     * Добавляем 3 элемента - два из которых одинаковы
     * Второй элемент должен быть second
     */
    @Test
    public void add() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        set.add("first");
        set.add("second");
        Iterator<String> it = set.iterator();
        it.next();
        String result = it.next();
        assertThat(result, is("second"));
    }
}