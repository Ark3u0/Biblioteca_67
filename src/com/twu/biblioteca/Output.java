package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Output {
    private final PrintStream out;

    public Output(final PrintStream out) {
        this.out = out;
    }

    public void write(final List<String> values) {
        out.println();
        values.forEach(out::println);
        out.println();
    }

    public void write(final String value) {
        out.println();
        out.println(value);
        out.println();
    }
}
