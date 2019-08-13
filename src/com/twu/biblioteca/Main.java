package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) throws IOException {
        final Book book1 = new Book("Stranger in a Strange Land", "Robert A. Heinlein", 1961);
        final Book book2 = new Book("1984", "George Orwell", 1949);
        final Book book3 = new Book("Fahrenheit 451", "Ray Bradbury", 1953);
        final Book book4 = new Book("Animal Farm", "George Orwell", 1945);
        final Book book5 = new Book("Brave New World", "Aldous Huxley", 1932);

        final Input in = new Input(new BufferedReader(new InputStreamReader(System.in)));
        final Output out = new Output(System.out);
        final Catalog catalog = new Catalog(asList(book1, book2, book3, book4, book5));

        final Menu menu = new Menu(asList(
                new ListBooks(out, catalog),
                new CheckoutBook(out, in, catalog),
                new Quit()
        ), out);

        new BibliotecaApp(
                out,
                in,
                menu).run();
    }
}
