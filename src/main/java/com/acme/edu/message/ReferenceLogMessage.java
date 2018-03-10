package com.acme.edu.message;

import com.acme.edu.prefix.ReferencePrefixAdder;

public class ReferenceLogMessage extends LogMessage {
    private Object value;

    public ReferenceLogMessage(Object value) {
        this.value = value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof ReferenceLogMessage;
    }

    @Override
    public String toString() {
        setPrefixAdder(new ReferencePrefixAdder());
        return getPrefixAdder().addPrefix() + value.toString();
    }
}