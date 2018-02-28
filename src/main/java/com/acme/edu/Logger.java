package com.acme.edu;

public class Logger {

    private static long byteState;
    private static long intState;

    public static String addPrefix(int choice){
        switch (choice) {
            case 1:
                return "primitive: ";
            case 2:
                return "char: ";
            case 3:
                return "string: ";
            case 4:
                return "reference: ";
            default:
                return "";
        }
    }

    private static void printOut(int choice, Object message) {
        System.out.println(addPrefix(choice) + message);
    }

    public static void flush() {
        intState = 0;
        byteState = 0;
    }

    public static void log(int message) {
        byteState = 0;

        if(intState + message >= Integer.MAX_VALUE) {
            intState = Integer.MAX_VALUE;
        } else {
            intState += message;
        }

        printOut(1, intState);
//        System.out.println(addPrefix(1) + message);
    }

    public static void log(byte message) {
        intState = 0;

        if(byteState + message >= Byte.MAX_VALUE) {
            byteState = Byte.MAX_VALUE;
        } else {
            byteState += message;
        }

        printOut(1, byteState);
//        System.out.println(addPrefix(1) + message);
    }

    public static void log(char message) {
        printOut(2, message);
//        System.out.println(addPrefix(2) + message);
    }

    public static void log(String message) {
        byteState = 0;
        intState = 0;

        printOut(3, message);
//        System.out.println(addPrefix(3) + message);
    }

    public static void log(boolean message) {
        printOut(1, message);
//      System.out.println(addPrefix(1) + message);
    }

    public static void log(Object message) {
        printOut(4, message);
//        System.out.println(addPrefix(4) + message);
    }
}