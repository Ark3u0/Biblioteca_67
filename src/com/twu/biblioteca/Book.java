package com.twu.biblioteca;

public class Book {
    private static Integer availableId = 1;

    private static Integer nextAvailableId() {
        return availableId++;
    }

    private Integer id;
    private BookStatus status;

    private String title;
    private String author;
    private int yearPublished;

    public Book(final String title, final String author, final int yearPublished) {
        this.id = nextAvailableId();
        this.status = BookStatus.AVAILABLE;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return String.format("%d: ", id) + String.join(", ", title, author, Integer.toString(yearPublished));
    }

    public Integer getId() {
        return id;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void checkout() {
        status = BookStatus.CHECKED_OUT;
    }
}
