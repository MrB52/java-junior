package com.acme.edu.message;

import com.acme.edu.prefix.PrefixAdder;

public abstract class LogMessage {
    private PrefixAdder prefixAdder;

    protected PrefixAdder getPrefixAdder() {
        return prefixAdder;
    }

    protected void setPrefixAdder(PrefixAdder prefixAdder) {
        this.prefixAdder = prefixAdder;
    }

    public abstract boolean isTypeMatched(LogMessage logMessage);
}
