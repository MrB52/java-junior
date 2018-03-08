package com.acme.edu.message.method;

public class Comparison {
    public static boolean IntComparison(int message) {
        return BufferState.intState + message >= Integer.MAX_VALUE;
    }

    public static boolean ByteComparison(byte message) {
        return BufferState.byteState + message >= Byte.MAX_VALUE;
    }

    public static boolean StringComparison(String message) {
        return BufferState.stringState.equals(message);
    }
}
