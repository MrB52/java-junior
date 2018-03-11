package com.acme.edu.visitor;

import com.acme.edu.message.*;

public class PrefixFormatterVisitor implements FormatterVisitor {
    @Override
    public String formatByteLogMessage(ByteLogMessage message) {
        return null;
    }

    @Override
    public String formatIntLogMessage(IntLogMessage message) {
        return null;
    }

    @Override
    public String formatIntArrayLogMessage(IntArrayLogMessage message) {
        return null;
    }

    @Override
    public String formatIntMatrixLogMessage(IntMatrixLogMessage message) {
        return null;
    }

    @Override
    public String formatBooleanLogMessage(BooleanLogMessage message) {
        return "primitive: " + message.getValue();
    }

    @Override
    public String formatCharLogMessage(CharLogMessage message) {
        return "char: " + message.getValue();
    }

    @Override
    public String formatStringLogMessage(StringLogMessage message) {
        return null;
    }

    @Override
    public String formatReferenceLogMessage(ReferenceLogMessage message) {
        return "reference: " + message.getValue();
    }
}
