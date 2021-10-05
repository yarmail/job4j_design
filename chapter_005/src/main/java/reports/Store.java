package reports;

import java.util.List;
import java.util.function.Predicate;

/**
 * Интерфейс хранилища
 */
public interface Store {
    /**
     * @param filter поиск сотрудников по критериям
     */
    List<Employee> findBy(Predicate<Employee> filter);
}
