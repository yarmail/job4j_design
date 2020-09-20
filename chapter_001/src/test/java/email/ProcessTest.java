package email;

import java.util.*;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProcessTest {
    /**
     * Из списка должно остаться только 2 пользователя
     */
    @Test
    public void processTest() {
        Map<String, HashSet<String>> source = new HashMap<>();
        source.put("user1", new HashSet<>(Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        source.put("user2", new HashSet<>(Arrays.asList("foo@gmail.com", "ups@pisem.net")));
        source.put("user3", new HashSet<>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com")));
        source.put("user4", new HashSet<>(Arrays.asList("ups@pisem.net", "aaa@bbb.ru")));
        source.put("user5", new HashSet<>(Arrays.asList("xyz@pisem.net")));

        Process run = new Process();
        Map<String, HashSet<String>> dest = new HashMap<>(run.getResult(source));

        for (String name : dest.keySet()) {
            System.out.println(name + ":" + dest.get(name).toString());
        }

        assertThat(dest.size(), is(2));
    }
}