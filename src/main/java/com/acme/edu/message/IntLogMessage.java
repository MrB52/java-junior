package com.acme.edu.message;

import com.acme.edu.prefix.PrimitivePrefixAdder;

public class IntLogMessage extends LogMessage {
    private int accumulatedValue;

    @Override
    public String toString() {
        setPrefixAdder(new PrimitivePrefixAdder());
        return getPrefixAdder().addPrefix() + accumulatedValue;
    }
}