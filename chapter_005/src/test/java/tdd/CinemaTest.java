package tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;


/**
 * Это модели тестов, НЕ ЗАПУСКАТЬ
 */
@Ignore
public class CinemaTest {

    /**
     * Тест проверяет
     * Чтобы описать тесты, мне потребовалось
     * создать пустые классы реализующие нужные интерфейсы.
     */
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    /**
     * Вероятно не хватает метода - добавить сеанс
     */
    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(List.of(new Session3D())));
    }

    @Test
    public void findTrue() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(List.of(new Session3D())));
    }

    @Test
    public void findFalse() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> false);
        assertThat(sessions, is(List.of(new Session3D())));
    }
}