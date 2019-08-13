package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(final String title, final String author, final int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return String.join(", ", title, author, Integer.toString(yearPublished));
    }
}
