package com.acme.edu.message;

import com.acme.edu.prefix.PrimitivePrefixAdder;

public class IntLogMessage extends NumberLogMessage {

    public IntLogMessage(long value) {
        setValue(value);
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof IntLogMessage;

    }

    @Override
    public String toString() {
        setPrefixAdder(new PrimitivePrefixAdder());

        if (isUpperOverflowStatus()) {
            return getPrefixAdder().addPrefix() + Integer.MAX_VALUE;
        }

        if (isLowerOverflowStatus()) {
            return getPrefixAdder().addPrefix() + Integer.MIN_VALUE;
        }

        return getPrefixAdder().addPrefix() + getValue();
    }
}