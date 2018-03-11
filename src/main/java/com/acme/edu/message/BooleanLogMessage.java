package com.acme.edu.message;

import com.acme.edu.prefix.PrimitivePrefixAdder;
import com.acme.edu.visitor.FormatterVisitor;

public class BooleanLogMessage extends LogMessage {
    private boolean value;

    public BooleanLogMessage(boolean value) {
        this.value = value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof BooleanLogMessage;
    }

    @Override
    public String acceptFormatterVisitor(FormatterVisitor formatterVisitor) {
        return null;
    }

    @Override
    public String toString() {
        setPrefixAdder(new PrimitivePrefixAdder());
        return getPrefixAdder().addPrefix() + value;
    }
}
