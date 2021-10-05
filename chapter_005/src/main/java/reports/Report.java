package reports;

import java.util.function.Predicate;

/**
 * Интерфейс отчетов
 */
public interface Report {
    String generate(Predicate<Employee> filter);
}
