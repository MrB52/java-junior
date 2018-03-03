package com.acme.edu;

public class Logger {
    private static long byteState;
    private static long intState;
    private static String stringState = "";
    private static int stringRepeatCounter;
    private static ConsoleProxyLogger consoleProxyLogger = new ConsoleProxyLogger();

    private static String addPrefix(long messsage){
        return "primitive: ";
    }

    private static String addPrefix(String messsage){
        return "string: ";
    }

    private static String addPrefix(int[][] messsage){
        return "primitives matrix: ";
    }

    private static void printOut(long message) {
        System.out.println(addPrefix(message) + message);
    }

    private static void printOut(String message) {
        System.out.println(addPrefix(message) + message);
    }

    public static void log(int[] message) {
        consoleProxyLogger.log(message);
    }

    public static void log(byte message) {
        flush(message);
        if(byteState + message >= Byte.MAX_VALUE) {
            byteState = Byte.MAX_VALUE;
        } else {
            byteState += message;
        }

        printOut(byteState);
    }

    public static void log(int message) {
        flush(message);
        if(intState + message >= Integer.MAX_VALUE) {
            intState = Integer.MAX_VALUE;
        } else {
            intState += message;
        }

        printOut(intState);
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
        flush(message);
        stringState = message;
        if(stringState.equals(message)) {
            stringRepeatCounter++;
        } else {
            stringRepeatCounter = 0;
        }
        if(stringRepeatCounter > 1) {
            message = message + " (x" + stringRepeatCounter + ")";
        }
        printOut(message);
    }

    public static void log(Object message) {
        consoleProxyLogger.log(message);
    }

    public static void flush() {
        intState = 0;
        byteState = 0;
        stringState = "";
    }

    private static void flush(byte message){
        intState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    private static void flush(int message){
        byteState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    private static void flush(String message){
        byteState = 0;
        intState = 0;
    }
}