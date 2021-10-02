package tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * Это реализация - уточнение, какой имено кинотеатр
 */
public class Cinema3D implements Cinema {
    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
}
