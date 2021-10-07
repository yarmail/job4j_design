package reports;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXML implements Report, Serializable {
    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    /**
     * Получаем контекст для доступа к API
     * JAXBContext context = JAXBContext.newInstance(Employee.class);
     *
     * Создаем сериализатор
     * Marshaller marshaller = context.createMarshaller();
     *
     * Указываем, что нам нужно форматирование
     * marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
     *
     *  Сериализуем
     *  for (Employee employee : store.findBy(filter)) {
     */
    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException, IOException {
        Employees employees = new Employees(store.findBy(filter));
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String rsl;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employees, writer);
            rsl = writer.getBuffer().toString();
        }
        return rsl;
    }
}
/*
StringBuilder text = new StringBuilder();
for (Employee employee : store.findBy(filter)) {
JAXBContext context = JAXBContext.newInstance(Employee.class);
Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
try (StringWriter writer = new StringWriter()) {
marshaller.marshal(employee, writer);
text.append(writer.getBuffer().toString());
}
}
return text.toString();
 */
