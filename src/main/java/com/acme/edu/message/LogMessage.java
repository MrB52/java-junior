package com.acme.edu.message;

import com.acme.edu.visitor.FormatterVisitor;

public interface LogMessage {

    boolean isTypeMatched(LogMessage logMessage);

    String acceptFormatterVisitor(FormatterVisitor formatterVisitor);
}
