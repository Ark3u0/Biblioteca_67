package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldWriteBookTitleAuthorAndYearToString() {
        Book book = new Book("TITLE", "AUTHOR", 1960);

        assertThat(book.toString(), containsString("TITLE, AUTHOR, 1960"));
    }
}