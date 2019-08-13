package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Menu {
    private List<Command> commands;
    private PrintStream out;

    public Menu(final List<Command> commands, final PrintStream out) {
        this.commands = commands;
        this.out = out;
    }

    public void select(final Integer selection, final BibliotecaApp app) {
        if (0 < selection && selection <= commands.size()) {
            Command command = commands.get(selection - 1);

            command.perform(out, app);
        } else {
            out.println("Please select a valid option!");
            print();
        }
    }

    public void print() {
        for (int i = 0; i < commands.size(); i++) {
            out.println(String.format("%d: %s", i + 1, commands.get(i)));
        }
    }
}
