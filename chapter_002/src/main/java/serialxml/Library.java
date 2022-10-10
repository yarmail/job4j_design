package serialxml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {
    @XmlAttribute
    private boolean isWork;
    private int numOfBooks;
    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "genre")
    private String[] genre;
    private Book book;

    public Library() {

    }

    public Library(boolean isWork, int numOfBooks, String[] genre, Book book) {
        this.isWork = isWork;
        this.numOfBooks = numOfBooks;
        this.genre = genre;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Library{"
                + "isWork=" + isWork
                + ", numOfBooks=" + numOfBooks
                + ", genre=" + Arrays.toString(genre)
                + ", book=" + book
                + '}';
    }
}