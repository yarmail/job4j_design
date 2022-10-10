package serialxml;

import java.util.Arrays;

public class Library {
    private final boolean isWork;
    private final int numOfBooks;
    private final String[] genre;
    private final Book book;

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

    public static void main(String[] args) {
        final Library library = new Library(false, 9746,
                new String[] {"Adventure", "Classics", "Detective"}, new Book("1984"));
    }
}