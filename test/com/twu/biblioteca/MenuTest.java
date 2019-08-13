package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private Menu menu;
    private Output output;
    private BibliotecaApp app;
    private Command command;
    private Catalog catalog;

    @Before
    public void setup() {
        command = mock(Command.class);
        output = mock(Output.class);
        app = mock(BibliotecaApp.class);
        catalog = mock(Catalog.class);
        menu = new Menu(singletonList(command), output);
    }

    @Test
    public void shouldPrintCommandsInNumberedOrder() {
        final ListBooks command1 = new ListBooks(null, catalog);
        final Quit command2 = new Quit();
        final ListBooks command3 = new ListBooks(null, catalog);

        menu = new Menu(asList(command1, command2, command3), output);
        menu.print();

        verify(output).write(asList(
                "Menu: ",
                String.format("1: %s", command1),
                String.format("2: %s", command2),
                String.format("3: %s", command3)
        ));
    }

    @Test
    public void shouldPerformCommandWhenUserGivesValidSelection() throws IOException {
        menu.select(1, app);

        verify(command).perform(app);
    }

    @Test
    public void shouldPrintInvalidOptionAndReprintMenuWhenUserGivesInvalidSelection() throws IOException {
        menu.select(2, app);

        verify(output).write("Please select a valid option!");
        verify(output).write(asList(
                "Menu: ",
                String.format("1: %s", command)));
    }
}