package com.acme.edu.message;

import com.acme.edu.visitor.FormatterVisitor;

//TODO сделать интерфейсом
public abstract class LogMessage {

    public abstract boolean isTypeMatched(LogMessage logMessage);

    public abstract String acceptFormatterVisitor(FormatterVisitor formatterVisitor);
}
