package com.acme.edu.message;

import com.acme.edu.visitor.FormatterVisitor;

public class BooleanLogMessage implements LogMessage {
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
        return formatterVisitor.formatBooleanLogMessage(this);
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}