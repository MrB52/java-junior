package com.acme.edu;

import com.acme.edu.message.Printer;

public class Logger {

    public static void log(int message) {
        Printer.printOut(message);
    }

    public static void log(byte message) {
    Printer.printOut(message);
    }

    public static void log(char message) {
        Printer.printOut(message);
    }

    public static void log(int[] message) {
        Printer.printOut(message);
    }

    public static void log(int[][] message) {
        Printer.printOut(message);
    }

    public static void log(String message) {
        Printer.printOut(message);
    }

    public static void log(boolean message) {
        Printer.printOut(message);
    }

    public static void log(Object message) {
        Printer.printOut(message);
    }
}