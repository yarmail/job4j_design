package reports;

import java.util.List;
import java.util.function.Predicate;

/**
 * С помощью полиформизма делаем
 * отчет для HR отдела
 * (тест для него, как ни странно - ReportEngineTest)
 * Задание: Отдел HR попросил выводить сотрудников
 * в порядке убывания зарплаты и убрать
 * поля даты найма и увольнения.
 */
public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> list = store.findBy(filter);
        list.sort((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
        text.append("Name; Salary;");
        for (Employee employee : list) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}