package map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UserTest {

    /**
     *  Ситуация 1.
     *  Смотрим как ведет себя модель User 1
     *  без переопределения hashcode и equals
     *
     *  Если бы ключи были одинаковыми
     *  (т.е. equals определял бы их одинаковыми)
     *  то map должен был бы заменить first на second
     *  и при печати оставить только 1 объект,
     *  но так как он считает их разными объектами
     *  то он их не заменяет и при печати мы видим их 2.
     *
     */
    @Test
    public void userOneTest() {
        UserOne first = new UserOne("Petr");
        UserOne second = new UserOne("Petr");
        System.out.println(first); // map.User@17d99928
        System.out.println(second); // map.User@3834d63f
        System.out.println(first.hashCode()); //984213526
        System.out.println(second.hashCode()); //400136488
        System.out.println(first.equals(second)); //false

        Map<UserOne, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map); // {map.User1@17d99928=second, map.User1@3aa9e816=first}
    }

    /**
     * Ситуация 2
     * Переопределяем только hashcode
     * на примере класса User2
     *
     * Когда мы не переопределяли hashcode
     * он показывал разные значения, а теперь,
     * когда переопределили, он показывает одинаковые
     *
     * Это позволяет предположить, что нативый
     * (не переопределенный) метод hashcode
     * как-то видит разницу между объектами
     * с одинаковыми полями.
     * Вероятно следует знать, как именно
     * работает нативный метод
     *
     * Однако, даже при одинаковых показателях
     * hashcode map показывает 2 объекта,
     * Это говорит о том, что этого не достаточно
     * и нужно ещё переопределять equals, если мы хотим
     * добиться замены в map
     * На данный момент print map все равно показывает 2 объекта
     *
     */
    @Test
    public void userTwoTest() {
        UserTwo first = new UserTwo("Petr");
        UserTwo second = new UserTwo("Petr");
        System.out.println(first); // map.User2@25e772
        System.out.println(second); // map.User2@25e772
        System.out.println(first.hashCode()); //2484082
        System.out.println(second.hashCode()); //2484082
        System.out.println(first.equals(second)); //false

        Map<UserTwo, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map); // {map.User2@25e772=first, map.User2@25e772=second}
    }
}