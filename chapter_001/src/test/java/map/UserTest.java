package map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

public class UserTest {
    User first = new User("Petr");
    User second = new User("Petr");

    /**
     * Как я понимаю, это демонстрация того,
     * одинаковые по значению объекты стандартным
     * equals будут восприниматься как разные,
     * т.к. в переменных ссылочных типах хранятся
     * разные адреса памяти
     */
    @Test
    public void printObj() {
        System.out.println(first); // map.User@17d99928
        System.out.println(second); // map.User@3834d63f
        System.out.println(first.equals(second)); //false
    }

    /**
     * Если бы ключи были одинаковыми
     * (т.е. equals определял бы их одинаковыми)
     * то map должен был бы заменить first на second
     * и при печати оставить только 1 объект,
     * но так как он считает их разными объектами
     * то он их не заменяет и при печати мы видим их 2.
     */
    @Test
    public void map() {
        Map<User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map); // 2 объекта {map.User@17d99928=first, map.User@3834d63f=second}

    }
}