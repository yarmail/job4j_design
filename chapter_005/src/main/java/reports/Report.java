package reports;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.function.Predicate;

/**
 * Интерфейс отчетов
 */
public interface Report {
    String generate(Predicate<Employee> filter) throws JAXBException, IOException;
}
