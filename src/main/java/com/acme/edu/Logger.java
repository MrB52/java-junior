package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.visitor.PrefixFormatterVisitor;

public class Logger {
    private static LoggerController loggerController = new LoggerController(System.out::println);

    public static void log(byte message) {
        loggerController.log(new ByteLogMessage(message), new PrefixFormatterVisitor());
    }

    public static void log(int message) {
        loggerController.log(new IntLogMessage(message), new PrefixFormatterVisitor());
    }

    public static void log(int[] message) {
        loggerController.log(new IntArrayLogMessage(message), new PrefixFormatterVisitor());
    }

    public static void log(int[][] message) {
        loggerController.log(new IntMatrixLogMessage(message), new PrefixFormatterVisitor());
    }

    public static void log(boolean message) {
        loggerController.log(new BooleanLogMessage(message), new PrefixFormatterVisitor());
    }

    public static void log(char message) {
        loggerController.log(new CharLogMessage(message), new PrefixFormatterVisitor());
    }

    public static void log(String message) {
        loggerController.log(new StringLogMessage(message), new PrefixFormatterVisitor());
    }

    public static void log(Object message) {
        loggerController.log(new ReferenceLogMessage(message), new PrefixFormatterVisitor());
    }

    //TODO внести в LoggerController
    public static void flush() {
        loggerController.flush(new PrefixFormatterVisitor());
    }
}