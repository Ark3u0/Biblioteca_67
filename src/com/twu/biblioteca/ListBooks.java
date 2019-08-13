package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class ListBooks implements Command {
    private final static List<Book> books = Arrays.asList(
            new Book("Stranger in a Strange Land", "Robert A. Heinlein", 1961),
            new Book("1984", "George Orwell", 1949),
            new Book("Fahrenheit 451", "Ray Bradbury", 1953),
            new Book("Animal Farm", "George Orwell", 1945),
            new Book("Brave New World", "Aldous Huxley", 1932));

    @Override
    public String toString() {
        return "List of books";
    }

    @Override
    public void perform(PrintStream out, final BibliotecaApp app) {
        for (Book book : books) {
            out.println(book.toString());
        }
    }
}
