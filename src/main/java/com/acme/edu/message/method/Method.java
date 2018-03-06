package com.acme.edu.message.method;

public class Method {

    public static long IntMethod(int message) {
        BufferState.buffer(message);
        if(Comparison.IntComparison(message)) {
            return BufferState.intState = Integer.MAX_VALUE;
        } else {
            return BufferState.intState += message;
        }
    }

    public static long ByteMethod(byte message) {
        BufferState.buffer(message);
        if(Comparison.ByteComparison(message)) {
            return BufferState.byteState = Byte.MAX_VALUE;
        } else {
            return BufferState.byteState += message;
        }
    }

    public static String StringMethod(String message) {
        BufferState.buffer(message);
        if(Comparison.StringComparison(message)) {
            BufferState.stringRepeatCounter++;
        } else {
            BufferState.stringRepeatCounter = 0;
        }
        if(BufferState.stringRepeatCounter > 1) {
            return BufferState.stringState = message + " (x" + BufferState.stringRepeatCounter + ")";
        }
        else return message;
    }

    public static StringBuilder ArrayMethod(int[] message) {
        BufferState.matrixState.append("{");
        if (message.length > 0) {
            for (int i = 0; i < message.length-1; i++) {
                BufferState.matrixState.append(message[i]).append(", ");
            }
            BufferState.matrixState.append(message[message.length - 1]);
        }
        return BufferState.matrixState.append("}");
    }

    public static StringBuilder MatrixMethod(int[][] message) {
        if(message.length > 0){
            for (int[] i : message) {
                BufferState.matrixState.append("{");

                for (int j = 0; j < i.length - 1; j++) {
                    BufferState.matrixState.append(i[j]).append(", ");
                }

                BufferState.matrixState.append(i[i.length - 1]).append("}\n");
            }
        }
        return BufferState.matrixState.append("}");
    }
}
