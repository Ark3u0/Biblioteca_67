package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    private PrintStream output;
    private Command command;

    @Before
    public void setup() {
        output = mock(PrintStream.class);
        command = new ListBooks();
    }

    @Test
    public void shouldListBooksWhenCommandIsPerformed() {
        command.perform(output, null);

        verify(output).println("Stranger in a Strange Land, Robert A. Heinlein, 1961");
        verify(output).println("1984, George Orwell, 1949");
        verify(output).println("Fahrenheit 451, Ray Bradbury, 1953");
        verify(output).println("Animal Farm, George Orwell, 1945");
        verify(output).println("Brave New World, Aldous Huxley, 1932");
    }
}