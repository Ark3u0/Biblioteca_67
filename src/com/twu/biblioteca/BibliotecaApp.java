package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;

public class BibliotecaApp {

    private final PrintStream out;
    private final Input input;
    private final Menu menu;
    private boolean isOpenForBusiness;

    public BibliotecaApp(final PrintStream out, final Input input, final Menu menu) {
        this.out = out;
        this.input = input;
        this.menu = menu;
        this.isOpenForBusiness = true;
    }

    public void run() throws IOException {
        welcome();

        while (isOpenForBusiness) {
            performBusiness();
        }
    }

    public void performBusiness() throws IOException {
        input.getSelection()
                .ifPresent(selection -> menu.select(selection, this));
    }

    public void welcome() {
        out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        menu.print();
    }

    public void quit() {
        isOpenForBusiness = false;
    }
}
