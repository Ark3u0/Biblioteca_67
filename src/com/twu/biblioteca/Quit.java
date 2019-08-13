package com.twu.biblioteca;

import java.io.PrintStream;

public class Quit implements Command {

    @Override
    public void perform(final PrintStream out, final BibliotecaApp app) {
        app.quit();
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
