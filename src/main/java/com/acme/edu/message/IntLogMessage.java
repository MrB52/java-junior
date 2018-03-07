package com.acme.edu.message;

import com.acme.edu.prefix.PrimitivePrefixAdder;

public class IntLogMessage extends LogMessage {
    private long accumulatedValue;

    public IntLogMessage(long accumulatedValue) {
        if(accumulatedValue >= Integer.MAX_VALUE) {
            this.accumulatedValue = Integer.MAX_VALUE;
        } else if (accumulatedValue <= Integer.MIN_VALUE) {
            this.accumulatedValue = Integer.MIN_VALUE;
        } else {
            this.accumulatedValue = accumulatedValue;
        }
    }

    public long getAccumulatedValue() {
        return accumulatedValue;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof IntLogMessage;

    }

    @Override
    public String toString() {
        setPrefixAdder(new PrimitivePrefixAdder());
        return getPrefixAdder().addPrefix() + accumulatedValue;
    }
}