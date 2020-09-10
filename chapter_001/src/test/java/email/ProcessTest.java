package email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProcessTest {
    /**
     * Из списка должно остаться только 2 пользователя
     */
    @Test
    public void processTest() {
        User user1 = new User("user1", new TreeSet<>(Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        User user2 = new User("user2", new TreeSet<>(Arrays.asList("foo@gmail.com", "ups@pisem.net")));
        User user3 = new User("user3", new TreeSet<>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com")));
        User user4 = new User("user4", new TreeSet<>(Arrays.asList("ups@pisem.net", "aaa@bbb.ru")));
        User user5 = new User("user5", new TreeSet<>(Arrays.asList("xyz@pisem.net")));
        ArrayList<User> sourceList = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
        Process classProcess = new Process();
        ArrayList<User> destList = new ArrayList<>(classProcess.process(sourceList));
        assertThat(destList.size(), is(2));
    }
}