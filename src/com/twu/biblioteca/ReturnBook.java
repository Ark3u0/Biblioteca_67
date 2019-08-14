package com.twu.biblioteca;

import java.io.IOException;
import java.util.Optional;

public class ReturnBook implements Command {
    private Output out;
    private Input input;
    private Catalog catalog;
    private ListBooks listBooksCommand;

    public ReturnBook(final Output out,
                      final Input input,
                      final Catalog catalog,
                      final ListBooks listBooksCommand) {
        this.out = out;
        this.input = input;
        this.catalog = catalog;
        this.listBooksCommand = listBooksCommand;
    }

    @Override
    public void perform(final BibliotecaApp app) throws IOException {
        listBooksCommand.printCheckedOutBookList();

        out.write("Enter id of book to return: ");
        Optional<Integer> selection = input.getSelection();
        if (selection.isPresent()) {
            Integer bookId = selection.get();
            BookStatus status = catalog.checkBookStatus(bookId);
            if (status == BookStatus.CHECKED_OUT) {
                catalog.returnBook(bookId);
                out.write("Thank you! We hope to see you again.");
            } else {
                out.write("Sorry, that book is not checked out in our system.");
            }
        }
    }

    @Override
    public String toString() {
        return "Return a book";
    }
}
