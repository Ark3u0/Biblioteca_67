package com.twu.biblioteca;

import java.io.IOException;
import java.util.Optional;

public class CheckoutBook implements Command {
    private final ListBooks listBooksCommand;
    private final Catalog catalog;
    private final Output out;
    private final Input input;

    public CheckoutBook(final Output out,
                        final Input input,
                        final Catalog catalog,
                        final ListBooks listBooks) {
        this.out = out;
        this.input = input;
        this.catalog = catalog;
        this.listBooksCommand = listBooks;
    }

    @Override
    public void perform(final BibliotecaApp app) throws IOException {
        listBooksCommand.printAvailableBookList();

        out.write("Enter id of book to checkout: ");
        Optional<Integer> selection = input.getSelection();
        if (selection.isPresent()) {
            Integer bookId = selection.get();
            BookStatus status = catalog.checkBookStatus(bookId);
            if (status == BookStatus.AVAILABLE) {
                catalog.checkoutBook(bookId);
                out.write("Thank you! Enjoy the book.");
            } else {
                out.write("Sorry, that book is not available.");
            }
        }
    }

    @Override
    public String toString() {
        return "Checkout a book";
    }
}
