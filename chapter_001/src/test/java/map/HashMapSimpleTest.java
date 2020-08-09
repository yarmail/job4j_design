package map;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Поправка: В тестах лучше не заводить поля,
 * это может привести к неожиданным ошибкам
 */
public class HashMapSimpleTest {

    /**
     * Удачная вставка
     */
    @Test
    public void insertTrue() {
        HashMapSimple<String, String> hashMap = new HashMapSimple<>();
        assertThat(hashMap.insert("first", "first"), is(true));
    }

    /**
     * Неудачная вставка
     */
    @Test
    public void insertFalse() {
        HashMapSimple<String, String> hashMap = new HashMapSimple<>();
        hashMap.insert("first", "first");
        assertThat(hashMap.insert("first", "second"), is(false));
    }

    /**
     * Удачное получение значения
     */
    @Test
    public void getFirst() {
        HashMapSimple<String, String> hashMap = new HashMapSimple<>();
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.get("first"), is("Vasya"));
    }

    /**
     * Неудачное получение элемента
     *
     */
    @Test
    public void getNull() {
        HashMapSimple<String, String> hashMap = new HashMapSimple<>();
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.get("second"), is(nullValue()));
    }

    @Test
    public void deleteTrue() {
        HashMapSimple<String, String> hashMap = new HashMapSimple<>();
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.delete("first"), is(true));
    }

    @Test
    public void deleteFalse() {
        HashMapSimple<String, String> hashMap = new HashMapSimple<>();
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.delete("second"), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        HashMapSimple<String, String> hashMap = new HashMapSimple<>();
        hashMap.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        HashMapSimple<String, String> hashMap = new HashMapSimple<>();
        hashMap.insert("first", "Vasya");
        Iterator<HashMapSimple.Node<String, String>> it = hashMap.iterator();
        hashMap.insert("second", "Petya");
        it.next();
    }
}