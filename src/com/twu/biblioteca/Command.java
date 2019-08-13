package com.twu.biblioteca;

import java.io.PrintStream;

public interface Command {
    void perform(PrintStream out, final BibliotecaApp app);
}
