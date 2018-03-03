package com.acme.edu.message;


public class Printer {
    public static void printOut(int message) {
        Flush.flush(message);
        if(Flush.intState + message >= Integer.MAX_VALUE) {
            Flush.intState = Integer.MAX_VALUE;
        } else {
            Flush.intState += message;
        }
        System.out.println(Flush.intState); // почему без этой строчки не работает???
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(byte message) {
        Flush.flush(message);
        if(Flush.byteState + message >= Byte.MAX_VALUE) {
            Flush.byteState = Byte.MAX_VALUE;
        } else {
            Flush.byteState += message;
        }
        System.out.println(Flush.byteState);
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(char message) {
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(String message) {
        Flush.flush(message);
        Flush.stringState = message;
        if(Flush.stringState.equals(message)) {
            Flush.stringRepeatCounter++;
        } else {
            Flush.stringRepeatCounter = 0;
        }
        if(Flush.stringRepeatCounter > 1) {
            message = message + " (x" + Flush.stringRepeatCounter + ")";
        }
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(Object message) {
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(boolean message) {
        System.out.println(AddPrefix.addPrefix(message) + message);
    }

    public static void printOut(int[] message) {
        StringBuilder buffer = new StringBuilder("{");
        if (message.length > 0) {
            for (int i = 0; i < message.length-1; i++) {
                buffer.append(message[i]).append(", ");
            }
            buffer.append(message[message.length - 1]);
        }
        buffer.append("}");

        System.out.println(AddPrefix.addPrefix(message) + buffer);
    }

    public static void printOut(int[][] message){
        StringBuilder buffer = new StringBuilder("{\n");
        if(message.length > 0){
            for (int[] element : message) {
                buffer.append("{");

                for (int j = 0; j < element.length - 1; j++) {
                    buffer.append(element[j]).append(", ");
                }

                buffer.append(element[element.length - 1]).append("}\n");
            }
        }
        buffer.append("}");
        System.out.println(AddPrefix.addPrefix(message) + buffer);
    }
}
