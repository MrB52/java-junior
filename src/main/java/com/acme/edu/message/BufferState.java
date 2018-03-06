package com.acme.edu.message;

public class BufferState {
    static long byteState;
    static long intState;
    static String stringState = "";
    static int stringRepeatCounter;
    static StringBuilder matrixState = new StringBuilder("");
    public static void buffer() {
        intState = 0;
        byteState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    public static void buffer(int message){
        byteState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    public static void buffer(byte message){
        intState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    public static void buffer(String message){
        byteState = 0;
        intState = 0;
    }
}
