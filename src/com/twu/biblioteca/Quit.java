package com.twu.biblioteca;

public class Quit implements Command {

    @Override
    public void perform(final BibliotecaApp app) {
        app.quit();
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
