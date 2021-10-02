package tddtemplate;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Это модели тестов НЕ ЗАПУСКАТЬ
 */
@Ignore
public class GeneratorTest {

    @Test
    public void whenAllRight() {
        Generator gen = new MyGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "SpiderMan");
        map.put("subject", "you");
        String etalon = "I am a SpiderMan, Who are you?";
        String rsl = gen.produce(template, map);
        assertThat(rsl, is(etalon));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoKey() {
        Generator gen = new MyGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "SpiderMan");
        String rsl = gen.produce(template, map);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAnotherKey() {
        Generator gen = new MyGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "SpiderMan");
        map.put("sub", "SpiderMan");
        String rsl = gen.produce(template, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMoreKeys() {
        Generator gen = new MyGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "SpiderMan");
        map.put("subject", "you");
        map.put("error", "here");
        String rsl = gen.produce(template, map);
    }
}