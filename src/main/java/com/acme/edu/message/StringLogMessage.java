package com.acme.edu.message;

import com.acme.edu.prefix.StringPrefixAdder;

public class StringLogMessage extends LogMessage {
    private String accumulatedValue;

    //TODO добавить логику аккумулирования
    public StringLogMessage(String accumulatedValue) {
        this.accumulatedValue = accumulatedValue;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof StringLogMessage;
    }

    @Override
    public String toString() {
        setPrefixAdder(new StringPrefixAdder());
        return getPrefixAdder().addPrefix() + accumulatedValue;
    }
}
