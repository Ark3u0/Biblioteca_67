package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import static com.twu.biblioteca.BookStatus.AVAILABLE;
import static com.twu.biblioteca.BookStatus.DOES_NOT_EXIST;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnBookTest {

    private Book book1;
    private Book book2;
    private Catalog catalog;
    private Output output;
    private Input input;
    private ReturnBook command;
    private ListBooks listBooksCommand;

    @Before
    public void setup() {
        book1 = new Book("Stranger in a Strange Land", "Robert A. Heinlein", 1961);
        book2 = new Book("1984", "George Orwell", 1949);
        book1.checkout();

        catalog = new Catalog(asList(book1, book2));
        listBooksCommand = mock(ListBooks.class);
        output = mock(Output.class);
        input = mock(Input.class);
        command = new ReturnBook(output, input, catalog, listBooksCommand);
    }

    @Test
    public void shouldListCheckedOutBooksWhenReturningBook() throws IOException {
        when(input.getSelection()).thenReturn(Optional.of(1));

        command.perform(null);

        verify(listBooksCommand).printCheckedOutBookList();
    }

    @Test
    public void shouldPromptUserToEnterIdOfBookAndNotifyThemIfSuccessfulReturn() throws IOException {
        when(input.getSelection()).thenReturn(Optional.of(book1.getId()));

        command.perform(null);

        verify(output).write("Enter id of book to return: ");
        verify(output).write("Thank you for returning the book.");

        assertThat(catalog.checkBookStatus(book1.getId()), is(AVAILABLE));
    }

    @Test
    public void shouldPromptUserToEnterIdOfBookAndNotifyThemIfUnsuccessfulReturn() throws IOException {
        when(input.getSelection()).thenReturn(Optional.of(book2.getId() + 1));

        command.perform(null);

        verify(output).write("Enter id of book to return: ");
        verify(output).write("That is not a valid book to return.");

        assertThat(catalog.checkBookStatus(book2.getId() + 1), is(DOES_NOT_EXIST));
    }
}