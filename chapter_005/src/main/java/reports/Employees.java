package reports;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    public Employees() { }

    @XmlElement(name = "employee")
    private List<Employee> employees;

    public Employees(List<Employee> list) {
        this.employees = list;
    }
}
/*
StringBuilder text = new StringBuilder();
text.append("[").append(System.lineSeparator());
    for (Employee employee : store.findBy(filter)) {
        String json = gson.toJson(employee);
        text.append(json);
        text.append(",").append(System.lineSeparator());
  }
        text.append("]");
        return text.toString();
 */
