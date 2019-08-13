package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;
    private Output out;

    public Menu(final List<Command> commands, final Output out) {
        this.commands = commands;
        this.out = out;
    }

    public void select(final Integer selection, final BibliotecaApp app) throws IOException {
        if (0 < selection && selection <= commands.size()) {
            Command command = commands.get(selection - 1);

            command.perform(app);

            if (command instanceof Quit) {
                return;
            }
        } else {
            out.write("Please select a valid option!");
        }

        print();
    }

    public void print() {
        List<String> toWrite = new ArrayList<>();

        toWrite.add("Menu: ");
        for (int i = 0; i < commands.size(); i++) {
            toWrite.add(String.format("%d: %s", i + 1, commands.get(i)));
        }

        out.write(toWrite);
    }
}
