package com.acme.edu;

import com.acme.edu.proxylogger.ConsoleProxyLogger;
import com.acme.edu.proxylogger.ProxyLogger;

/**
 * <code>Logger</code> - класс, предоставлющий внешний API для взаимодействия с приложением.
 *
 * <p>Содержит один перегруженный метод log(), предназначенный для логгирования сообщений</p>
 */

public class Logger {
    private static ProxyLogger proxyLogger = new ConsoleProxyLogger();

    public static void log(byte message) {
        proxyLogger.log(message);
    }

    public static void log(int message) {
        proxyLogger.log(message);
    }

    public static void log(int[] message) {
        proxyLogger.log(message);
    }

    public static void log(int[][] message) {
        proxyLogger.log(message);
    }

    public static void log(boolean message) {
        proxyLogger.log(message);
    }

    public static void log(char message) {
        proxyLogger.log(message);
    }

    public static void log(String message) {
        proxyLogger.log(message);
    }

    public static void log(Object message) {
        proxyLogger.log(message);
    }
}