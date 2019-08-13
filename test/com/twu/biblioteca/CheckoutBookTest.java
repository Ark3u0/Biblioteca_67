package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import static com.twu.biblioteca.BookStatus.CHECKED_OUT;
import static com.twu.biblioteca.BookStatus.DOES_NOT_EXIST;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBookTest {

    private Book book1;
    private Book book2;
    private CheckoutBook command;
    private ListBooks listBooksCommand;
    private Output output;
    private Input input;
    private Catalog catalog;

    @Before
    public void setup() {
        book1 = new Book("Stranger in a Strange Land", "Robert A. Heinlein", 1961);
        book2 = new Book("1984", "George Orwell", 1949);

        catalog = new Catalog(asList(book1, book2));

        output = mock(Output.class);
        input = mock(Input.class);
        listBooksCommand = mock(ListBooks.class);
        command = new CheckoutBook(output, input, catalog, listBooksCommand);
    }

    @Test
    public void shouldListBooksWhenCheckingOutBook() throws IOException {
        when(input.getSelection()).thenReturn(Optional.of(1));

        command.perform(null);

        verify(listBooksCommand).perform(null);
    }

    @Test
    public void shouldPromptUserToEnterIdOfBookAndNotifyThemIfSuccessfulCheckout() throws IOException {
        when(input.getSelection()).thenReturn(Optional.of(book1.getId()));

        command.perform(null);

        verify(output).write("Enter id of book to checkout: ");
        verify(output).write("Thank you! Enjoy the book.");

        assertThat(catalog.checkBookStatus(book1.getId()), is(CHECKED_OUT));
    }

    @Test
    public void shouldPromptUserToEnterIdOfBookAndNotifyThemIfUnsuccessfulCheckout() throws IOException {
        when(input.getSelection()).thenReturn(Optional.of(book2.getId() + 1));

        command.perform(null);

        verify(output).write("Enter id of book to checkout: ");
        verify(output).write("Sorry, that book is not available.");

        assertThat(catalog.checkBookStatus(book2.getId() + 1), is(DOES_NOT_EXIST));
    }

}