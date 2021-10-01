package comparator;

import org.junit.Test;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Test.
 */
public class MaxMinATest {
    /**
     * Test max().
     * List of Integer objects.
     * Should return max element from given list with given comparator.
     */
    @Test
    public void whenMaxFromIntegersThenReturnMax() {
        MaxMinA maxMinExample = new MaxMinA();
        List<Integer> list = List.of(145, 2, 3, 40, 5, 6, 7, 877);
        Integer expected = list.stream().max(Comparator.naturalOrder()).get();
        Integer result = maxMinExample.max(list, Integer::compareTo);
        assertEquals(result, expected);
    }

    /**
     * Test max().
     * List of Integer objects.
     * Should return max element from given list with given comparator.
     */
    @Test
    public void whenMinFromIntegersThenReturnMin() {
        MaxMinA maxMinExample = new MaxMinA();
        List<Integer> list = List.of(145, 2, 3, 40, 5, 6, 7, 877);
        Integer expected = list.stream().min(Comparator.naturalOrder()).get();
        Integer result = maxMinExample.min(list, Integer::compareTo);
        assertEquals(result, expected);
    }

    /**
     * Test max().
     * List of String objects.
     * Should return max element from given list with given comparator.
     */
    @Test
    public void whenMaxFromStringThenReturnMax() {
        MaxMinA maxMinExample = new MaxMinA();
        List<String> list = List.of("a", "ab", "b", "i", "Zzz");
        String expected = list.stream().max(Comparator.naturalOrder()).get();
        String result = maxMinExample.max(list, String::compareTo);
        assertEquals(result, expected);
    }

    /**
     * Test max().
     * List of String objects.
     * Should return max element from given list with given comparator.
     */
    @Test
    public void whenMinFromStringThenReturnMin() {
        MaxMinA maxMinExample = new MaxMinA();
        List<String> list = List.of("a", "ab", "b", "i", "Zzz");
        String expected = list.stream().min(Comparator.naturalOrder()).get();
        String result = maxMinExample.min(list, String::compareTo);
        assertEquals(result, expected);
    }
}