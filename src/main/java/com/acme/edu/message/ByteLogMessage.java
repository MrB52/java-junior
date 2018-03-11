package com.acme.edu.message;

import com.acme.edu.prefix.PrimitivePrefixAdder;
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
        return null;
    }

    @Override
    public String toString() {
        setPrefixAdder(new PrimitivePrefixAdder());

        if (isUpperOverflowStatus()) {
            return getPrefixAdder().addPrefix() + Byte.MAX_VALUE;
        }

        if (isLowerOverflowStatus()) {
            return getPrefixAdder().addPrefix() + Byte.MIN_VALUE;
        }

        return getPrefixAdder().addPrefix() + getValue();
    }
}