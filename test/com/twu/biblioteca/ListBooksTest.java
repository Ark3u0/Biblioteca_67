package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    private Output output;
    private Command command;
    private Catalog catalog;
    private Book book1;
    private Book book2;

    @Before
    public void setup() {
        book1 = new Book("Stranger in a Strange Land", "Robert A. Heinlein", 1961);
        book2 = new Book("1984", "George Orwell", 1949);
        catalog = new Catalog(asList(book1, book2));
        output = mock(Output.class);
        command = new ListBooks(output, catalog);
    }

    @Test
    public void shouldListBooksWhenCommandIsPerformed() throws IOException {
        command.perform(null);

        verify(output).write(asList(
                "Books: ",
                book1.toString(),
                book2.toString()
        ));
    }
}