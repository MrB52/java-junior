package com.acme.edu.message;

public class Flush {
    static long byteState;
    static long intState;
    static String stringState = "";
    static int stringRepeatCounter;
    public static void flush() {
        intState = 0;
        byteState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    public static void flush(int message){
        byteState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    public static void flush(byte message){
        intState = 0;
        stringState = "";
        stringRepeatCounter = 0;
    }

    public static void flush(String message){
        byteState = 0;
        intState = 0;
    }
}
