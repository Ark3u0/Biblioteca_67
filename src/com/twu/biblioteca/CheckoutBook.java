package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutBook implements Command {
    private Output out;
    private Input input;
    private final Catalog catalog;

    public CheckoutBook(final Output out, final Input input, final Catalog catalog) {
        this.out = out;
        this.input = input;
        this.catalog = catalog;
    }

    @Override
    public void perform(final BibliotecaApp app) throws IOException {
        new ListBooks(out, catalog).perform(app);

        out.write("Enter id of book to checkout: ");
        input.getSelection().ifPresent(bookId -> {
            BookStatus status = catalog.checkBookStatus(bookId);
            if (status == BookStatus.AVAILABLE) {
                catalog.checkoutBook(bookId);
                out.write(String.format("Book with id %d successfully checked out.", bookId));
            } else {
                out.write(String.format("Book with id %d is unavailable.", bookId));
            }
        });
    }

    @Override
    public String toString() {
        return "Checkout a book";
    }
}
