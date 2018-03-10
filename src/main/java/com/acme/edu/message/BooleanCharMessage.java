package com.acme.edu.message;

import com.acme.edu.prefix.PrimitivePrefixAdder;

public class BooleanCharMessage extends LogMessage {
    private boolean value;

    public BooleanCharMessage(boolean value) {
        this.value = value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof BooleanCharMessage;
    }

    @Override
    public String toString() {
        setPrefixAdder(new PrimitivePrefixAdder());
        return getPrefixAdder().addPrefix() + value;
    }
}
