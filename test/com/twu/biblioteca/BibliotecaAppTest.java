package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private BibliotecaApp app;
    private PrintStream output;
    private Input input;
    private Menu menu;

    @Before
    public void setup() {
        output = mock(PrintStream.class);
        input = mock(Input.class);
        menu = mock(Menu.class);
        app = new BibliotecaApp(output, input, menu);
    }

    @Test
    public void shouldMakeMenuSelectionIfInputIsPresent() throws IOException {
        when(input.getSelection()).thenReturn(Optional.of(1));

        app.performBusiness();

        verify(menu).select(1, app);
    }

    @Test
    public void shouldDoNothingIfSelectionIsNotMade() throws IOException {
        when(input.getSelection()).thenReturn(Optional.empty());

        app.performBusiness();

        verify(menu, never()).select(anyInt(), any(BibliotecaApp.class));
    }

    @Test
    public void shouldWelcomeUsersAndPrintMenuOnStartUp() throws IOException {
        app.welcome();

        verify(output).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        verify(menu).print();
    }
}
