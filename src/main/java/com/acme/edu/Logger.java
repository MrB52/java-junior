package com.acme.edu;

public class Logger {

    private static long byteState;
    private static long intState;
    private static String stringState = "";
    private static int stringRepeatCounter;

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
            case 5:
                return "primitives array: ";
            case 6:
                return "primitives matrix: ";
            default:
                return "";
        }
    }

    private static void printOut(int choice, Object message) {
        System.out.println(addPrefix(choice) + message);
    }

    private static void printOut(int choice, int[] message) {
        String buffer = "{";
        if (message.length > 0) {
            for (int i = 0; i < message.length-1; i++) {
                buffer += message[i] + ", ";
            }
            buffer += message[message.length-1];
        }
        buffer += "}";

        System.out.println(addPrefix(choice) + buffer);
    }

    private static void printOut(int choice, int[][] message){
        String buffer = "{\n";

        if(message.length > 0){
            for (int i = 0; i < message.length; i++) {
                buffer += "{";

                for (int j = 0; j < message[i].length-1; j++) {
                    buffer += message[i][j] + ", ";
                }

            buffer += message[i][message[i].length-1];
            buffer += "}\n";
            }
        }
        buffer += "}";
        System.out.println(addPrefix(6) + buffer);
    }

    public static void flush() {
        intState = 0;
        byteState = 0;
        stringState = "";
    }

    public static void log(int message) {
        byteState = 0;
        stringState = "";
        stringRepeatCounter = 0;
        if(intState + message >= Integer.MAX_VALUE) {
            intState = Integer.MAX_VALUE;
        } else {
            intState += message;
        }

        printOut(1, intState);
    }

    public static void log(byte message) {
        intState = 0;
        stringState = "";
        stringRepeatCounter = 0;

        if(byteState + message >= Byte.MAX_VALUE) {
            byteState = Byte.MAX_VALUE;
        } else {
            byteState += message;
        }

        printOut(1, byteState);
    }

    public static void log(char message) {
        printOut(2, message);
    }

    public static void log(int[] message) {
        printOut(5, message);
    }

    public static void log(int[][] message) {
        printOut(6, message);
    }

    public static void log(String message) {
        byteState = 0;
        intState = 0;

        stringState = message;
        if(stringState.equals(message)) {
            stringRepeatCounter++;
        } else {
            stringRepeatCounter = 0;
        }

        if(stringRepeatCounter > 1) {
            message = message + " (x" + stringRepeatCounter + ")";
        }

        printOut(3, message);
    }

    public static void log(boolean message) {
        printOut(1, message);
    }

    public static void log(Object message) {
        printOut(4, message);
    }
}