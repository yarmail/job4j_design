package reports;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

/**
 * немного странно, что мы имеем везде
 * предикады для фильтрации
 * а пользуемся изменением подачи (вида),
 * возможно это должно делаться в зависимости от роли того, кто запрашивает
 */
public class ReportEngineTest {
    /**
     * Это исходный вариант теста для основного класса
     * Это как бы пожелания, к чему мы должны прийти в итоге,
     * с учетом требований разных департаметов.
     * По методологи TDD Сначала мы пишем тест,
     * а потом подгоняем к нему результат
     * Как я понимаю, самая важная строка
     * Report engine = new ReportEngine(store);
     * Это то, какой движок для генерации отчета мы будем использовать
     *
     */
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    /**
     * Тест для класса ReportHR
     * Задание
     * Отдел HR попросил выводить сотрудников
     * порядке убывания зарплаты и убрать
     * поля даты найма и увольнения.
     */
    @Test
    public void forHR()  {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Boris", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    /**
     * Тест класса ReportProg
     * Задание Отдел программистов потребовал ответы в виде html
     */
    @Test
    public void forProg() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportProg(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE HTML>")
                .append("<html><head><meta charset=\"utf-8\"><title>Report</title></head><body><table>")
                .append("<tr>")
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</tr>")
                .append("<tr><td>").append(worker.getName()).append("</tr><td>")
                .append("<tr><td>").append(worker.getHired()).append("</tr><td>")
                .append("<tr><td>").append(worker.getFired()).append("</tr><td>")
                .append("<tr><td>").append(worker.getSalary()).append("</tr><td>")
                .append("</table></body></html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    /**
     * Отдел бухгалтерии попросил изменить вид зарплаты
     * (в данном случае USD)
     * (тест класса ReportFinance)
     */
    @Test
    public void forFinance() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportFinance(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary USD;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / 72).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}