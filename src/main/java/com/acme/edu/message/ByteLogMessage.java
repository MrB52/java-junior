package com.acme.edu.message;

import com.acme.edu.prefix.PrimitivePrefixAdder;

public class ByteLogMessage extends NumberLogMessage {

    public ByteLogMessage(long value) {
        setValue(value);
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof ByteLogMessage;

    }

    @Override
    public String toString() {
        setPrefixAdder(new PrimitivePrefixAdder());

        if (isUpperOverflowStatus()) {
            return getPrefixAdder().addPrefix() + Byte.MAX_VALUE;
        }

        if (isLowerOverflowStatus()) {
            return getPrefixAdder().addPrefix() + Byte.MIN_VALUE;
        }

        return getPrefixAdder().addPrefix() + getValue();
    }
}