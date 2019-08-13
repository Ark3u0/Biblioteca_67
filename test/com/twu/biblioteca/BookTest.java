package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldWriteBookTitleAuthorAndYearToString() {
        Book book = new Book("TITLE", "AUTHOR", 1960);

        assertEquals("TITLE, AUTHOR, 1960", book.toString());
    }
}