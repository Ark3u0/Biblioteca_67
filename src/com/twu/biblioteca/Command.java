package com.twu.biblioteca;

import java.io.IOException;

public interface Command {
    void perform(final BibliotecaApp app) throws IOException;
}
