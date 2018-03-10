package com.acme.edu.message;

import com.acme.edu.prefix.PrimitiveArrayPrefixAdder;

public class IntArrayLogMessage extends LogMessage {
    private int[] value;

    public IntArrayLogMessage(int[] value) {
        this.value = value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof IntArrayLogMessage;
    }

    @Override
    public String toString() {
        StringBuilder bufferedValue = new StringBuilder("{");

        setPrefixAdder(new PrimitiveArrayPrefixAdder());
        if (value.length > 0) {
            for (int i = 0; i < value.length-1; i++) {
                bufferedValue.append(value[i]).append(", ");
            }
            bufferedValue.append(value[value.length - 1]);
        }
        bufferedValue.append("}");

        return getPrefixAdder().addPrefix() + bufferedValue;
    }
}