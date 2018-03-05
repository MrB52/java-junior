package com.acme.edu.message;


public class Printer {
    public static void printOut(int message) {
        Method.IntMethod(message);
        System.out.println(AddPrefix.addPrefix(message) + BufferState.intState);
    }

    public static void printOut(byte message) {
        Method.ByteMethod(message);
        System.out.println(AddPrefix.addPrefix(message) + BufferState.intState);
    }

    public static void printOut(char message) {
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(String message) {
        Method.StringMethod(message);
        System.out.println(AddPrefix.addPrefix(message) + BufferState.stringState);
    }

    public static void printOut(Object message) {
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(boolean message) {
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(int[] message) {
        Method.ArrayMethod(message);
        System.out.println(AddPrefix.addPrefix(message) + BufferState.matrixState);
    }

    public static void printOut(int[][] message){
        Method.MatrixMethod(message);
        System.out.println(AddPrefix.addPrefix(message) + BufferState.matrixState);
    }
}
