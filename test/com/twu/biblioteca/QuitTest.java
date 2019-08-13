package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitTest {

    @Test
    public void shouldQuitApplicationWhenCommandIsPerformed() throws IOException {
        Command command = new Quit();

        BibliotecaApp app = mock(BibliotecaApp.class);

        command.perform(app);

        verify(app).quit();
    }
}