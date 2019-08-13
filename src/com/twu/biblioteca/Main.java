package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) throws IOException {
        final Menu menu = new Menu(asList(
                new ListBooks(),
                new Quit()
        ), System.out);
        new BibliotecaApp(
                System.out,
                new Input(new BufferedReader(new InputStreamReader(System.in))),
                menu).run();
    }
}
