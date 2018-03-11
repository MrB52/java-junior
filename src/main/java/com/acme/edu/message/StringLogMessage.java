package com.acme.edu.message;

import com.acme.edu.prefix.StringPrefixAdder;
import com.acme.edu.visitor.FormatterVisitor;

public class StringLogMessage extends LogMessage {
    private String value;
    private int stringRepetitionCounter = 1;

    public StringLogMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof StringLogMessage;
    }

    @Override
    public String acceptFormatterVisitor(FormatterVisitor formatterVisitor) {
        return formatterVisitor.formatStringLogMessage(this);
    }

    public void increaseStringRepetitionCounter() {
        stringRepetitionCounter++;
    }

    @Override
    public String toString() {

        if (stringRepetitionCounter > 1) {
            return new StringBuilder(value).append(" (x")
                                           .append(stringRepetitionCounter)
                                           .append(")").toString();
        }
        return value;
    }
}
