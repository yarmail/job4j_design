package tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * Интерфейс кинотеатра
 * Сделаны тесты, в которых показаны классы - заглушки?
 * Задание.
 * Посмотрите на созданные тесты. Опишите, каких тестов тут не хватает?
 * Допишите не достающие тесты. Классы реализовывать не нужно
 */
public interface Cinema {
    /**
     * найти список доступных сеансов?
     */
    List<Session> find(Predicate<Session> filter);

    /**
     * параметры купленного билета?
     */
    Ticket buy(Account account, int row, int column, Calendar date);

    /**
     * добавить сеанс?
     */
    void add(Session session);
}
