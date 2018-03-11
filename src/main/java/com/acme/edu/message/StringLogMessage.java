package com.acme.edu.message;

import com.acme.edu.prefix.StringPrefixAdder;

public class StringLogMessage extends LogMessage {
    private String value;
    private int stringRepetitionCounter = 1;

    public StringLogMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean isTypeMatched(LogMessage logMessage) {
        return logMessage instanceof StringLogMessage;
    }

    public void increaseStringRepetitionCounter() {
        stringRepetitionCounter++;
    }

    public void resetSttingRepetetionCounter() {
        stringRepetitionCounter = 0;
    }

    @Override
    public String toString() {
        setPrefixAdder(new StringPrefixAdder());

        if (stringRepetitionCounter > 1) {
            return new StringBuilder(getPrefixAdder().addPrefix()).append(value)
                                                                  .append(" (x")
                                                                  .append(stringRepetitionCounter)
                                                                  .append(")").toString();
        }
        return getPrefixAdder().addPrefix() + value;
    }
}
