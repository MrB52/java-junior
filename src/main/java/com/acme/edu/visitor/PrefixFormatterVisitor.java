package com.acme.edu.visitor;

import com.acme.edu.message.*;
import com.acme.edu.prefix.EmptyPrefixAdder;
import com.acme.edu.prefix.PrefixAdder;

public class PrefixFormatterVisitor implements FormatterVisitor {
    private PrefixAdder prefixAdder;

    public PrefixFormatterVisitor() {
        prefixAdder = new EmptyPrefixAdder();
    }

    public PrefixFormatterVisitor(PrefixAdder prefixAdder) {
        this.prefixAdder = prefixAdder;
    }

    @Override
    public String formatByteLogMessage(ByteLogMessage message) {
        return prefixAdder.addPrefix() + message;
    }

    @Override
    public String formatIntLogMessage(IntLogMessage message) {
        return prefixAdder.addPrefix() + message;
    }

    @Override
    public String formatIntArrayLogMessage(IntArrayLogMessage message) {
        return prefixAdder.addPrefix() + message;
    }

    @Override
    public String formatIntMatrixLogMessage(IntMatrixLogMessage message) {
        return prefixAdder.addPrefix() + message;
    }

    @Override
    public String formatBooleanLogMessage(BooleanLogMessage message) {
        return prefixAdder.addPrefix() + message;
    }

    @Override
    public String formatCharLogMessage(CharLogMessage message) {
        return prefixAdder.addPrefix() + message;
    }

    @Override
    public String formatStringLogMessage(StringLogMessage message) {
        return prefixAdder.addPrefix() + message;
    }

    @Override
    public String formatReferenceLogMessage(ReferenceLogMessage message) {
        return prefixAdder.addPrefix() + message;
    }
}