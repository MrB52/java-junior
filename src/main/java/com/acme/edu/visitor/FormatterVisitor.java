package com.acme.edu.visitor;

import com.acme.edu.message.*;
import com.acme.edu.prefix.PrefixAdder;

public interface FormatterVisitor {
    String formatByteLogMessage(ByteLogMessage message);

    String formatIntLogMessage(IntLogMessage message);

    String formatIntArrayLogMessage(IntArrayLogMessage message);

    String formatIntMatrixLogMessage(IntMatrixLogMessage message);

    String formatBooleanLogMessage(BooleanLogMessage message);

    String formatCharLogMessage(CharLogMessage message);

    String formatStringLogMessage(StringLogMessage message);

    String formatReferenceLogMessage(ReferenceLogMessage message);

    default String formatLogMessage(LogMessage message) {
        return message.acceptFormatterVisitor(this);
    }
}
