package com.acme.edu;

import com.acme.edu.printer.ConsolePrinter;

/**
 * <code>Logger</code> - класс, предоставлющий внешний API для взаимодействия с приложением.
 *
 * <p>Содержит один перегруженный метод log(), предназначенный для логгирования сообщений</p>
 */

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsolePrinter());

    public static void log(byte message) {
        loggerController.log(message);
    }

    public static void log(int message) {
        loggerController.log(message);
    }

    public static void log(int[] message) {
        loggerController.log(message);
    }

    public static void log(int[][] message) {
        loggerController.log(message);
    }

    public static void log(boolean message) {
        loggerController.log(message);
    }

    public static void log(char message) {
        loggerController.log(message);
    }

    public static void log(String message) {
        loggerController.log(message);
    }

    public static void log(Object message) {
        loggerController.log(message);
    }
}