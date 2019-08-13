package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private Menu menu;
    private PrintStream output;
    private BibliotecaApp app;
    private Command command;

    @Before
    public void setup() {
        command = mock(Command.class);
        output = mock(PrintStream.class);
        app = mock(BibliotecaApp.class);
        menu = new Menu(singletonList(command), output);
    }

    @Test
    public void shouldPrintCommandsInNumberedOrder() {
        final ListBooks command1 = new ListBooks();
        final Quit command2 = new Quit();
        final ListBooks command3 = new ListBooks();

        menu = new Menu(asList(command1, command2, command3), output);
        menu.print();

        verify(output).println(String.format("1: %s", command1));
        verify(output).println(String.format("2: %s", command2));
        verify(output).println(String.format("3: %s", command3));
    }

    @Test
    public void shouldPerformCommandWhenUserGivesValidSelection() {
        menu.select(1, app);

        verify(command).perform(output, app);
    }

    @Test
    public void shouldPrintInvalidOptionAndReprintMenuWhenUserGivesInvalidSelection() {
        menu.select(2, app);

        verify(output).println("Please select a valid option!");
        verify(output).println(String.format("1: %s", command));
    }
}