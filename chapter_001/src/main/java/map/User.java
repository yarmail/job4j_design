package map;

import java.util.Calendar;

/**
 * Это модель
 * Настройки hashcode и equals проводим здесь
 * Тесты - hashcode и equals проводим в тесте
 * Результаты выносим в package-info.java
 */

public class User {

    private String name;
    int children;
    Calendar bithday;

    public User(String name) {
        this.name = name;
    }
}
