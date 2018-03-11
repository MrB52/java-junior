package com.acme.edu.printer;

public class ConsolePrinter implements Printer{

    @Override
    public void printOut(String message) {
        System.out.println(message);
    }
}