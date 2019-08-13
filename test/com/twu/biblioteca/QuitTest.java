package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitTest {

    @Test
    public void shouldQuitApplicationWhenCommandIsPerformed() {
        Command command = new Quit();

        BibliotecaApp app = mock(BibliotecaApp.class);

        command.perform(null, app);

        verify(app).quit();
    }
}