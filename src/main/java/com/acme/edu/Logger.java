package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.visitor.PrefixFormatterVisitor;

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsolePrinter());

    public static void log(byte message) {
        loggerController.log(new ByteLogMessage(message));
    }

    public static void log(int message) {
        loggerController.log(new IntLogMessage(message)); //TODO сдеалть возможность добавлять префикс через конструктор
    }

    public static void log(int[] message) {
        loggerController.log(new IntArrayLogMessage(message));
    }

    public static void log(int[][] message) {
        loggerController.log(new IntMatrixLogMessage(message));
    }

    public static void log(boolean message) {
        loggerController.log(new BooleanLogMessage(message));
    }

    public static void log(char message) {
        loggerController.log(new CharLogMessage(message));
    }

    public static void log(String message) {
        loggerController.log(new StringLogMessage(message));
    }

    public static void log(Object message) {
        loggerController.log(new ReferenceLogMessage(message), new PrefixFormatterVisitor());
    }

    public static void flush() {
        loggerController.getPrinter().printOut(loggerController.getPreviousLogMessage().toString());
        loggerController.setPreviousLogMessage(null);
    }
}