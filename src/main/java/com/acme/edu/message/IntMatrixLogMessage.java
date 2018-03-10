package com.acme.edu.message;

import com.acme.edu.prefix.PrimitiveMatrixPrefixAdder;

public class IntMatrixLogMessage extends LogMessage {
    private int[][] value;

    public IntMatrixLogMessage(int[][] value) {
        this.value = value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof IntMatrixLogMessage;
    }

    @Override
    public String toString() {
        StringBuilder bufferedValue = new StringBuilder("{\n");

        setPrefixAdder(new PrimitiveMatrixPrefixAdder());
        if(value.length > 0){
            for (int[] element : value) {
                bufferedValue.append("{");

                for (int j = 0; j < element.length - 1; j++) {
                    bufferedValue.append(element[j]).append(", ");
                }

                bufferedValue.append(element[element.length - 1]).append("}\n");
            }
        }
        bufferedValue.append("}");

        return getPrefixAdder().addPrefix() + bufferedValue;
    }
}
