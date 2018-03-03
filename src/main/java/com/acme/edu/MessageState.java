package com.acme.edu;

public class MessageState {
    private static int byteMessageState;
    private static long intMessageState;
    private static String stringMessageState = "";
    private static int stringMessageRepeatCounter;

    public static int getByteMessageState() {
        return byteMessageState;
    }

    public static void setByteMessageState(int byteMessageState) {
        flushByByteMessageState();

        if(MessageState.byteMessageState + byteMessageState >= Byte.MAX_VALUE) {
            MessageState.byteMessageState = Byte.MAX_VALUE;
        } else if (MessageState.byteMessageState + byteMessageState <= Byte.MIN_VALUE) {
            MessageState.byteMessageState = Byte.MIN_VALUE;
        } else {
            MessageState.byteMessageState += byteMessageState;
        }
    }

    public static long getIntMessageState() {
        return intMessageState;
    }

    public static void setIntMessageState(long intMessageState) {
        flushByIntMessageState();

        if(MessageState.intMessageState + intMessageState >= Integer.MAX_VALUE) {
            MessageState.intMessageState = Integer.MAX_VALUE;
        } else if (MessageState.intMessageState + intMessageState <= Integer.MIN_VALUE) {
            MessageState.intMessageState = Integer.MIN_VALUE;
        } else {
            MessageState.intMessageState += intMessageState;
        }
    }

    public static String getStringMessageState() {
        return stringMessageState;
    }

    public static void setStringMessageState(String stringMessageState) {
        flushByStringMessageState();

        MessageState.stringMessageState = stringMessageState;
        if(MessageState.stringMessageState.equals(stringMessageState)) {
            MessageState.stringMessageRepeatCounter++;
        } else {
            MessageState.stringMessageRepeatCounter = 0;
        }
        if(MessageState.stringMessageRepeatCounter > 1) {
            MessageState.stringMessageState = stringMessageState + " (x" + MessageState.stringMessageRepeatCounter + ")";
        }

    }

    public static void flush() {
        MessageState.byteMessageState = 0;
        MessageState.intMessageState = 0;
        MessageState.stringMessageState = "";
        MessageState.stringMessageRepeatCounter = 0;
    }

    private static void flushByByteMessageState() {
        MessageState.intMessageState = 0;
        MessageState.stringMessageState = "";
        MessageState.stringMessageRepeatCounter = 0;
    }

    private static void flushByIntMessageState() {
        MessageState.byteMessageState = 0;
        MessageState.stringMessageState = "";
        MessageState.stringMessageRepeatCounter = 0;
    }

    private static void flushByStringMessageState() {
        MessageState.byteMessageState = 0;
        MessageState.intMessageState = 0;
    }
}