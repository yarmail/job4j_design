package map;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class HashMapSimpleTest {

    private HashMapSimple<String, String> hashMap = new HashMapSimple<>();

    @Test
    public void insertTrue() {
        assertThat(hashMap.insert("first", "first"), is(true));
    }

    @Test
    public void insertFalse() {
        hashMap.insert("first", "first");
        assertThat(hashMap.insert("first", "second"), is(false));
    }

    @Test
    public void getFirst() {
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.get("first"), is("Vasya"));
    }

    @Ignore
    @Test (expected = NullPointerException.class)
    public void getNull() {
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.get("second"), is(nullValue()));
    }

    @Test
    public void deleteTrue() {
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.delete("first"), is(true));
    }
    @Ignore
    @Test (expected = NullPointerException.class)
    public void deleteFalse() {
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.delete("second"), is(false));
    }
}