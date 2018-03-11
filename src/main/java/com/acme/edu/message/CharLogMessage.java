package com.acme.edu.message;

import com.acme.edu.prefix.CharPrefixAdder;
import com.acme.edu.visitor.FormatterVisitor;

public class CharLogMessage extends LogMessage {
    private char value;

    public CharLogMessage(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof CharLogMessage;
    }

    @Override
    public String acceptFormatterVisitor(FormatterVisitor formatterVisitor) {
        return formatterVisitor.formatCharLogMessage(this);
    }

//    @Override
//    public String toString() {
//        setPrefixAdder(new CharPrefixAdder());
//        return getPrefixAdder().addPrefix() + value;
//    }
}
