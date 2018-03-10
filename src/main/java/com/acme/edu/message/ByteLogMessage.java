package com.acme.edu.message;

import com.acme.edu.prefix.PrimitivePrefixAdder;

public class ByteLogMessage extends LogMessage {
    private int accumulatedValue;

    public ByteLogMessage(int accumulatedValue) {
        if(accumulatedValue >= Byte.MAX_VALUE) {
            this.accumulatedValue = Byte.MAX_VALUE;
        } else if (accumulatedValue <= Byte.MIN_VALUE) {
            this.accumulatedValue = Byte.MIN_VALUE;
        } else {
            this.accumulatedValue = accumulatedValue;
        }
    }

    public long getAccumulatedValue() {
        return accumulatedValue;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof ByteLogMessage;

    }

    @Override
    public String toString() {
        setPrefixAdder(new PrimitivePrefixAdder());
        return getPrefixAdder().addPrefix() + accumulatedValue;
    }
}