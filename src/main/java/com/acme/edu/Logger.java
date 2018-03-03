package com.acme.edu;

public class Logger {
    private static ConsoleProxyLogger consoleProxyLogger = new ConsoleProxyLogger();

    public static void log(byte message) {
        consoleProxyLogger.log(message);
    }

    public static void log(int message) {
        consoleProxyLogger.log(message);
    }

    public static void log(int[] message) {
        consoleProxyLogger.log(message);
    }

    public static void log(int[][] message) {
        consoleProxyLogger.log(message);
    }

    public static void log(boolean message) {
        consoleProxyLogger.log(message);
    }

    public static void log(char message) {
        consoleProxyLogger.log(message);
    }

    public static void log(String message) {
        consoleProxyLogger.log(message);
    }

    public static void log(Object message) {
        consoleProxyLogger.log(message);
    }
}