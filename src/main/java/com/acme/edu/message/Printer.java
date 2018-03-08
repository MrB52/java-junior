package com.acme.edu.message;


import com.acme.edu.message.method.Method;

public class Printer {
    public static void printOut(int message) {
        System.out.println(AddPrefix.addPrefix(message) + Method.IntMethod(message));
    }

    public static void printOut(byte message) {
        System.out.println(AddPrefix.addPrefix(message) + Method.ByteMethod(message));
    }

    public static void printOut(char message) {
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(String message) {
        System.out.println(AddPrefix.addPrefix(message) + Method.StringMethod(message));
    }

    public static void printOut(Object message) {
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(boolean message) {
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(int[] message) {
        System.out.println(AddPrefix.addPrefix(message) + Method.ArrayMethod(message));
    }

    public static void printOut(int[][] message){
        System.out.println(AddPrefix.addPrefix(message) + Method.MatrixMethod(message));
    }
}
