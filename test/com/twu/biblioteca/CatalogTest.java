package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CatalogTest {

    private Book book1;
    private Book book2;
    private Catalog catalog;

    @Before
    public void setup() {
        book1 = new Book("Title1", "Author1", 1);
        book2 = new Book("Title2", "Author2", 2);

        book1.checkout();

        catalog = new Catalog(asList(book1, book2));
    }

    @Test
    public void shouldCheckStatusOfAvailableBook() {
        assertThat(catalog.checkBookStatus(book2.getId()), is(BookStatus.AVAILABLE));
    }

    @Test
    public void shouldCheckStatusOfCheckedOutBook() {
        assertThat(catalog.checkBookStatus(book1.getId()), is(BookStatus.CHECKED_OUT));
    }

    @Test
    public void shouldCheckStatusOfBookThatDoesNotExist() {
        assertThat(catalog.checkBookStatus(-1), is(BookStatus.DOES_NOT_EXIST));
    }

    @Test
    public void shouldSetStatusFromAvailableToCheckedOutWhenCheckingOutBook() {
        assertThat(book2.getStatus(), is(BookStatus.AVAILABLE));

        catalog.checkoutBook(book2.getId());

        assertThat(book2.getStatus(), is(BookStatus.CHECKED_OUT));
    }

    @Test
    public void shouldListBooksThatAreAvailable() {
        List<Book> availableBooks = catalog.listAvailableBooks();

        assertThat(availableBooks, is(singletonList(book2)));
    }

    @Test
    public void shouldListBooksThatAreCheckedOut() {
        List<Book> availableBooks = catalog.listCheckedOutBooks();

        assertThat(availableBooks, is(singletonList(book1)));
    }
}