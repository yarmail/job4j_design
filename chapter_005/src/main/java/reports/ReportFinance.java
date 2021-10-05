package reports;

import java.util.function.Predicate;

/**
 * Отдел бухгалтерии попросил изменить вид зарплаты
 * (в данно случае USD)
 * (тест в классе ReportEngineTest)
 */
public class ReportFinance implements Report {
    private Store store;

    public ReportFinance(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary USD;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / 72).append(";");
        }
        return text.toString();
    }
}
