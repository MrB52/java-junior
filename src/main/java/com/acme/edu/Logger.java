package com.acme.edu;

public class Logger {

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

    public static void printOut(int choice, String messageNew) {
        System.out.println(addPrefix(choice) + messageNew);
    }

    //TODO подумать над повторным использованием кода
    public static void log(int message) {
        printOut(1,"" + message);
//        System.out.println(addPrefix(1) + message);
    }

    public static void log(byte message) {
        printOut(1,"" + message);
//        System.out.println(addPrefix(1) + message);
    }

    public static void log(char message) {
//        System.out.println(addPrefix(2) + message);
        printOut(2,"" + message);
    }

    public static void log(String message) {
//        System.out.println(addPrefix(3) + message);
        printOut(3,"" + message);
    }

    public static void log(boolean message) {
//      System.out.println(addPrefix(1) + message);
        printOut(1,"" + message);
    }

    public static void log(Object message) {
//        System.out.println(addPrefix(4) + message);
        printOut(4,"" + message);
    }
}