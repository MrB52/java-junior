package com.acme.edu.printer;

import com.acme.edu.message.LogMessage;

public class ConsolePrinter implements Printer{
    @Override
    public void printOut(LogMessage message) {
        System.out.println(message);
    }
}