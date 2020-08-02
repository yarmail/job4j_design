package map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

public class UserTest {

    /**
     *  Ситуация 1.
     *  Смотрим как ведет себя модель UserA
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
    public void userATest() {
        UserA first = new UserA("Petr");
        UserA second = new UserA("Petr");
        System.out.println(first); // map.User@17d99928
        System.out.println(second); // map.User@3834d63f
        System.out.println(first.hashCode()); //984213526
        System.out.println(second.hashCode()); //400136488
        System.out.println(first.equals(second)); //false

        Map<UserA, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map); // {map.User1@17d99928=second, map.User1@3aa9e816=first}
    }

    /**
     * Ситуация 2
     * Переопределяем только hashcode
     * на примере класса UserB
     *
     * Когда мы не переопределяли hashcode
     * он показывал разные значения, а теперь,
     * когда переопределили, он показывает одинаковые
     *
     * Это позволяет предположить, что нативый
     * (не переопределенный) метод hashcode
     * видит разницу между объектами
     * т.к. объекты находятся в разных местах памяти
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
    public void userBTest() {
        UserB first = new UserB("Petr");
        UserB second = new UserB("Petr");
        System.out.println(first); // map.User2@25e772
        System.out.println(second); // map.User2@25e772
        System.out.println(first.hashCode()); //2484082
        System.out.println(second.hashCode()); //2484082
        System.out.println(first.equals(second)); //false

        Map<UserB, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map); // {map.User2@25e772=first, map.User2@25e772=second}
    }

    /**
     * Переопределяем только equals без hashcode
     * на примере класса UserC
     * Используем переопределение по умолчанию от Idea
     * Используется сравнение по полям
     *
     * first.equals(second) показывает true - то есть по
     * equals объекты одинаковые
     *
     * Однако (не переопределенный) hashcode показывает,
     * что объекты разные т.к. он настроен не на расчетах
     * по полям
     *
     * Таким образом, при укладке в map println показывает
     * 2 объекта, а не затирает один другим
     */
    @Ignore // см ограничения по классу UserC
    @Test
    public void userCTest() {
        UserC first = new UserC("Petr");
        UserC second = new UserC("Petr");
        System.out.println(first); // map.UserC@3aa9e816
        System.out.println(second); // map.UserC@17d99928
        System.out.println(first.hashCode()); //984213526
        System.out.println(second.hashCode()); //400136488
        System.out.println(first.equals(second)); //true

        Map<UserC, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map); // {map.UserC@17d99928=second, map.UserC@3aa9e816=first}
    }

    /**
     * В этом примере переопределяем equals и hashcode
     * на примере класса UserD и наблюдаем результаты
     * И equals и hashcode показывают равенство ключей
     *
     * В результате мы видим, что при добавлении в маp - второй
     * ключ заменил первый и остался там один.
     *
     * Общий вывод: внимательно, аккуратно и правильно работать c equals
     * и hashcode объектов, во многих случаях (например hashmap)
     * требуется переопределение и того и другого для правильной
     * работы по сравнению.
     */
    @Test
    public void userDTest() {
        UserD first = new UserD("Petr");
        UserD second = new UserD("Petr");
        System.out.println(first); // map.UserD@25e772
        System.out.println(second); // map.UserD@25e772
        System.out.println(first.hashCode()); //2484082
        System.out.println(second.hashCode()); //2484082
        System.out.println(first.equals(second)); //true

        Map<UserD, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map); // {map.UserD@25e772=second}
    }
}