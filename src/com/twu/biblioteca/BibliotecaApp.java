package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private final PrintStream out;

    public BibliotecaApp(final PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args) {
        new BibliotecaApp(System.out).run();
    }

    public List<String> getBooks() {
        List<String> books = new ArrayList<>();

        books.add("Stranger in a Strange Land");
        books.add("1984");
        books.add("Fahrenheit 451");
        books.add("Animal Farm");
        books.add("Brave New World");

        return books;
    }

    public void run() {
        out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        List<String> books = getBooks();

        for (String book : books) {
            out.println(book);
        }
    }
}
