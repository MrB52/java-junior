package com.acme.edu.message;

import com.acme.edu.visitor.FormatterVisitor;

public class IntLogMessage extends NumberLogMessage {

    public IntLogMessage() {
    }

    public IntLogMessage(long value) {
        setValue(value);
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof IntLogMessage;

    }

    @Override
    public String acceptFormatterVisitor(FormatterVisitor formatterVisitor) {
        return formatterVisitor.formatIntLogMessage(this);
    }

    @Override
    public String toString() {
        return Long.toString(getValue());
    }
}