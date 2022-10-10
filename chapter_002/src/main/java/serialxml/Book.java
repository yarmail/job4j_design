package serialxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book {
    @XmlAttribute
    private String name;

    public Book() {

    }

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{"
                + "name='" + name + '\''
                + '}';
    }
}
