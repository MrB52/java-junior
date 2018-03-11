package com.acme.edu.message;

import com.acme.edu.visitor.FormatterVisitor;

public class ByteLogMessage extends NumberLogMessage {

    public ByteLogMessage(long value) {
        setValue(value);
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof ByteLogMessage;

    }

    @Override
    public String acceptFormatterVisitor(FormatterVisitor formatterVisitor) {
        return formatterVisitor.formatByteLogMessage(this);
    }

    @Override
    public String toString() {

        if (isUpperOverflowStatus()) {
            return Long.toString(Byte.MAX_VALUE);
        }

        if (isLowerOverflowStatus()) {
            return Long.toString(Byte.MIN_VALUE);
        }

        return Long.toString(getValue());
    }
}