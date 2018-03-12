package com.acme.edu.message;

public abstract class NumberLogMessage implements LogMessage {
    private long value;
    private boolean upperOverflowStatus;
    private boolean lowerOverflowStatus;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isUpperOverflowStatus() {
        return upperOverflowStatus;
    }

    public void setUpperOverflowStatus(boolean upperOverflowStatus) {
        this.upperOverflowStatus = upperOverflowStatus;
    }

    public boolean isLowerOverflowStatus() {
        return lowerOverflowStatus;
    }

    public void setLowerOverflowStatus(boolean lowerOverflowStatus) {
        this.lowerOverflowStatus = lowerOverflowStatus;
    }
}
