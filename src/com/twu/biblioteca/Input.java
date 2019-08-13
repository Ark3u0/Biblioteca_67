package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

public class Input {
    private BufferedReader reader;

    public Input(final BufferedReader reader) {
        this.reader = reader;
    }

    public Optional<Integer> getSelection() throws IOException {
        String line = reader.readLine();
        reader.reset();

        try {
            return Optional.of(Integer.parseInt(line));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }

    }
}
