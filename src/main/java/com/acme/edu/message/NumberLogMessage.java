package com.acme.edu.message;

public abstract class NumberLogMessage implements LogMessage {
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}