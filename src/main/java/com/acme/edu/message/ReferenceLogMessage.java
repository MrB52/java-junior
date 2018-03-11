package com.acme.edu.message;

import com.acme.edu.visitor.FormatterVisitor;

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
    public String acceptFormatterVisitor(FormatterVisitor formatterVisitor) {
        return formatterVisitor.formatReferenceLogMessage(this);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}