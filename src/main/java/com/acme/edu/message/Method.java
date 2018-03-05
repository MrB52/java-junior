package com.acme.edu.message;

public class Method {

    public static void IntMethod(int message) {
        BufferState.buffer(message);
        if(BufferState.intState + message >= Integer.MAX_VALUE) {
            BufferState.intState = Integer.MAX_VALUE;
        } else {
            BufferState.intState += message;
        }
    }

    public static void ByteMethod(byte message) {
        BufferState.buffer(message);
        if(BufferState.byteState + message >= Byte.MAX_VALUE) {
            BufferState.byteState = Byte.MAX_VALUE;
        } else {
            BufferState.byteState += message;
        }
    }

    public static void StringMethod(String message) {
        BufferState.buffer(message);
        BufferState.stringState = message;
        if(BufferState.stringState.equals(message)) {
            BufferState.stringRepeatCounter++;
        } else {
            BufferState.stringRepeatCounter = 0;
        }
        if(BufferState.stringRepeatCounter > 1) {
            BufferState.stringState = message + " (x" + BufferState.stringRepeatCounter + ")";
        }
    }

    public static void ArrayMethod(int[] message) {
        if (message.length > 0) {
            for (int i = 0; i < message.length-1; i++) {
                BufferState.matrixState.append(message[i]).append(", ");
            }
            BufferState.matrixState.append(message[message.length - 1]);
        }
        BufferState.matrixState.append("}");
    }

    public static void MatrixMethod(int[][] message) {
        if(message.length > 0){
            for (int[] element : message) {
                BufferState.matrixState.append("{");

                for (int j = 0; j < element.length - 1; j++) {
                    BufferState.matrixState.append(element[j]).append(", ");
                }

                BufferState.matrixState.append(element[element.length - 1]).append("}\n");
            }
        }
        BufferState.matrixState.append("}");
    }
}
