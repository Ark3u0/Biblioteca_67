package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Catalog {
    private Map<Integer, Book> bookEntries;

    public Catalog(List<Book> books) {
        bookEntries = new HashMap<>();
        for (Book book : books) {
            bookEntries.put(book.getId(), book);
        }
    }

    public List<Book> listCheckedOutBooks() {
        return bookEntries.values()
                .stream()
                .filter(book -> book.getStatus()
                        .equals(BookStatus.CHECKED_OUT))
                .collect(toList());
    }

    public List<Book> listAvailableBooks() {
        return bookEntries.values()
                .stream()
                .filter(book -> book.getStatus()
                        .equals(BookStatus.AVAILABLE))
                .collect(toList());
    }

    public BookStatus checkBookStatus(final Integer bookId) {
        if (bookEntries.containsKey(bookId)) {
            Book book = bookEntries.get(bookId);
            return book.getStatus();
        } else {
            return BookStatus.DOES_NOT_EXIST;
        }
    }

    public void checkoutBook(final Integer bookId) {
        Book book = bookEntries.get(bookId);
        book.checkout();
    }

    public void returnBook(final Integer bookId) {
        Book book = bookEntries.get(bookId);
        book.returnBack();
    }
}
