package com.acme.edu;

public class Logger {

    private static long byteState;
    private static long intState;
    private static String stringState = "";
    private static int stringRepeatCounter;

    public static String addPrefix(long messsage){
        return "primitive: ";
    }

    public static String addPrefix(char messsage){
        return "char: ";
    }

    public static String addPrefix(String messsage){
        return "string: ";
    }

    public static String addPrefix(Object messsage){
        return "reference: ";
    }

    public static String addPrefix(boolean messsage){
        return "primitive: ";
    }

    public static String addPrefix(int[] messsage){
        return "primitives array: ";
    }

    public static String addPrefix(int[][] messsage){
        return "primitives matrix: ";
    }

    private static void printOut(long message) {
        System.out.println(addPrefix(message) + message);
    }

    private static void printOut(char message) {
        System.out.println(addPrefix(message) + message);
    }

    private static void printOut(String message) {
        System.out.println(addPrefix(message) + message);
    }

    private static void printOut(Object message) {
        System.out.println(addPrefix(message) + message);
    }

    private static void printOut(boolean message) {
        System.out.println(addPrefix(message) + message);
    }

    private static void printOut(int[] message) {
        String buffer = "{";
        if (message.length > 0) {
            for (int i = 0; i < message.length-1; i++) {
                buffer += message[i] + ", ";
            }
            buffer += message[message.length-1];
        }
        buffer += "}";

        System.out.println(addPrefix(message) + buffer);
    }

    private static void printOut(int[][] message){
        String buffer = "{\n";
        if(message.length > 0){
            for (int i = 0; i < message.length; i++) {
                buffer += "{";

                for (int j = 0; j < message[i].length-1; j++) {
                    buffer += message[i][j] + ", ";
                }

                buffer += message[i][message[i].length-1] + "}\n";
            }
        }
        buffer += "}";
        System.out.println(addPrefix(message) + buffer);
    }

    public static void flush() {
        intState = 0;
        byteState = 0;
        stringState = "";
    }

    private static void flush(int message){
        byteState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    private static void flush(byte message){
        intState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    private static void flush(String message){
        byteState = 0;
        intState = 0;
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

    public static void log(byte message) {
        flush(message);
        if(byteState + message >= Byte.MAX_VALUE) {
            byteState = Byte.MAX_VALUE;
        } else {
            byteState += message;
        }

        printOut(byteState);
    }

    public static void log(char message) {
        printOut(message);
    }

    public static void log(int[] message) {
        printOut(message);
    }

    public static void log(int[][] message) {
        printOut(message);
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

    public static void log(boolean message) {
        printOut(message);
    }

    public static void log(Object message) {
        printOut(message);
    }
}