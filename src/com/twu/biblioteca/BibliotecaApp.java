package com.twu.biblioteca;

import java.io.IOException;
import java.util.Optional;

public class BibliotecaApp {

    private final Output out;
    private final Input input;
    private final Menu menu;
    private boolean isOpenForBusiness;

    public BibliotecaApp(final Output out, final Input input, final Menu menu) {
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
        Optional<Integer> selection = input.getSelection();
        if (selection.isPresent()) {
            menu.select(selection.get(), this);
        }
    }

    public void welcome() {
        out.write("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        menu.print();
    }

    public void quit() {
        isOpenForBusiness = false;
    }
}
