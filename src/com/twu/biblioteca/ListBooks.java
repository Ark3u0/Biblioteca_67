package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ListBooks implements Command {
    private Output out;
    private Catalog catalog;

    public ListBooks(final Output out, final Catalog catalog) {
        this.out = out;
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "List of books";
    }

    public void printAvailableBookList() {
        List<String> toWrite = new ArrayList<>();

        toWrite.add("Books: ");
        for (Book book : catalog.listAvailableBooks()) {
            toWrite.add(book.toString());
        }

        out.write(toWrite);
    }

    public void printCheckedOutBookList() {
        List<String> toWrite = new ArrayList<>();

        toWrite.add("Books: ");
        for (Book book : catalog.listCheckedOutBooks()) {
            toWrite.add(book.toString());
        }

        out.write(toWrite);
    }

    @Override
    public void perform(final BibliotecaApp app) {
        printAvailableBookList();
    }
}
