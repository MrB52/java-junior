package com.acme.edu;

/**
 * <code>MessageState</code> - класс, содержащий нобор полей для описания состояния сообщений и набор методов для задания,
 * получения и изменения состояния сообщений.
 */

public class MessageState {
    private static int byteMessageState;
    private static long intMessageState;
    private static String stringMessageState = "";
    private static int stringMessageRepeatCounter;

    /**
     * Возвращает значение счетчика для сообщения типа byte.
     * @return значение счетчика для сообщения типа byte.
     */
    public static int getByteMessageState() {
        return byteMessageState;
    }

    /**
     * <p>Устанвливает значение счетчика для сообщения типа byte.</p>
     * <p>Максимальное значение аргумента byteMessageState равняется Byte.MAX_VALUE</p>
     * <p>Минимальное значение аргумента byteMessageState равняется Byte.MIN_VALUE</p>
     * @param byteMessageState значение счетчика сообщения типа byte.
     */
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

    /**
     * Возвращает значение счетчика для сообщения типа int.
     * @return значение счетчика для сообщения типа int.
     */
    public static long getIntMessageState() {
        return intMessageState;
    }

    /**
     * <p>Устанвливает значение счетчика для сообщения типа int.</p>
     * <p>Максимальное значение аргумента byteMessageState равняется Integer.MAX_VALUE</p>
     * <p>Минимальное значение аргумента byteMessageState равняется Integer.MIN_VALUE</p>
     * @param intMessageState значение счетчика сообщения типа int.
     */
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

    /**
     * Возвращает значение последнего сообщения типа String.
     * @return значение последнего сообщения типа String.
     */
    public static String getStringMessageState() {
        return stringMessageState;
    }

    /**
     * <p>Устанвливает значение сообщения типа String.</p>
     * @param stringMessageState значение сообщения типа String.
     */
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

    /**
     * Сбрасывает все состояния сообщений в ноль соответствующего типа.
     */
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