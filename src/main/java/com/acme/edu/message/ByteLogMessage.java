package com.acme.edu.message;

import com.acme.edu.prefix.PrimitivePrefixAdder;

public class ByteLogMessage extends LogMessage {
    private long value;

    public ByteLogMessage(long value) {
        if(value >= Byte.MAX_VALUE) {
            this.value = Byte.MAX_VALUE;
        } else if (value <= Byte.MIN_VALUE) {
            this.value = Byte.MIN_VALUE;
        } else {
            this.value = value;
        }
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof ByteLogMessage;

    }

    @Override
    public String toString() {
        setPrefixAdder(new PrimitivePrefixAdder());
        return getPrefixAdder().addPrefix() + value;
    }
}