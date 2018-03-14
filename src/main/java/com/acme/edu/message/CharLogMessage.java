package com.acme.edu.message;

import com.acme.edu.visitor.FormatterVisitor;

public class CharLogMessage implements LogMessage {
    private char value;

    public CharLogMessage(char value) {
        this.value = value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof CharLogMessage;
    }

    @Override
    public String acceptFormatterVisitor(FormatterVisitor formatterVisitor) {
        return formatterVisitor.formatCharLogMessage(this);
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}