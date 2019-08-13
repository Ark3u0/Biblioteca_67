package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private BibliotecaApp app;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setup() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        app = new BibliotecaApp(printStream);
    }

    private BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(outputStream.toByteArray())));
    }

    @Test
    public void shouldShowWelcomeMessageWhenStartingApplication() throws IOException {
        app.run();

        BufferedReader reader = getReader();

        String actual = reader.readLine();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", actual);
    }

    @Test
    public void shouldShowAllBooksAvailableAfterWelcomeMessageAppears() throws IOException {
        app.run();

        BufferedReader reader = getReader();

        // Re-read welcome message
        reader.readLine();

        List<String> books = reader.lines()
                .collect(Collectors.toList());

        assertThat(books, hasItems(
                "Stranger in a Strange Land",
                "1984",
                "Fahrenheit 451",
                "Animal Farm",
                "Brave New World"
        ));
    }
}
