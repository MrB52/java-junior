package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.printer.Printer;
import com.acme.edu.visitor.FormatterVisitor;

import java.util.function.Supplier;

public class LoggerController {
    private LogMessage previousLogMessage;
    private Printer printer;

    public LoggerController(Printer printer) {
        this.printer = printer;
    }

    public void log(ByteLogMessage message, FormatterVisitor formatterVisitor) {
        checkReadinessForPrintOut(message, formatterVisitor);

        if (checkAccumulatingNecessity(message)) {
            previousLogMessage = getAccumulatedNumberLogMessage(message, Byte.MIN_VALUE, Byte.MAX_VALUE,
                    formatterVisitor, ByteLogMessage::new);
        }
    }

    public void log(IntLogMessage message, FormatterVisitor formatterVisitor) {
        checkReadinessForPrintOut(message, formatterVisitor);

        if (checkAccumulatingNecessity(message)) {
            previousLogMessage = getAccumulatedNumberLogMessage(message, Integer.MIN_VALUE, Integer.MAX_VALUE,
                                                                formatterVisitor, IntLogMessage::new);
        }
    }

    public void log(IntArrayLogMessage message, FormatterVisitor formatterVisitor) {
        printer.printOut(formatterVisitor.formatLogMessage(message));
    }

    public void log(IntMatrixLogMessage message, FormatterVisitor formatterVisitor) {
        printer.printOut(formatterVisitor.formatLogMessage(message));
    }

    public void log(BooleanLogMessage message, FormatterVisitor formatterVisitor) {
        printer.printOut(formatterVisitor.formatLogMessage(message));
    }

    public void log(CharLogMessage message, FormatterVisitor formatterVisitor) {
        printer.printOut(formatterVisitor.formatLogMessage(message));
    }

    public void log(StringLogMessage message, FormatterVisitor formatterVisitor) {
        checkReadinessForPrintOut(message, formatterVisitor);

        if (checkAccumulatingNecessity(message)) {

            if (message.getValue().equals(((StringLogMessage)previousLogMessage).getValue())) {
                ((StringLogMessage) previousLogMessage).increaseStringRepetitionCounter();
            } else {
                printer.printOut(previousLogMessage.toString());
                previousLogMessage = message;
            }
        }
    }

    public void log(ReferenceLogMessage message, FormatterVisitor formatterVisitor) {
        printer.printOut(formatterVisitor.formatLogMessage(message));
    }

    public void flush(FormatterVisitor formatterVisitor) {
        printer.printOut(formatterVisitor.formatLogMessage(previousLogMessage));
        previousLogMessage = null;
    }

    private void checkReadinessForPrintOut(LogMessage message, FormatterVisitor formatterVisitor) {
        if (previousLogMessage != null && !message.isTypeMatched(previousLogMessage)) {
            printer.printOut(formatterVisitor.formatLogMessage(previousLogMessage));
        }
    }

    private boolean checkAccumulatingNecessity(LogMessage message) {
        if (previousLogMessage == null || !message.isTypeMatched(previousLogMessage)) {
            previousLogMessage = message;
            return false;
        }
        return true;
    }

    private NumberLogMessage getAccumulatedNumberLogMessage(NumberLogMessage numberLogMessage, long minValue, long maxValue,
                                                            FormatterVisitor formatterVisitor, Supplier<NumberLogMessage> supplier) {

        NumberLogMessage accumulatedNumberLogMessage = supplier.get();

        if (numberLogMessage.getValue() + ((NumberLogMessage)previousLogMessage).getValue() >= maxValue) {
            accumulatedNumberLogMessage.setValue(numberLogMessage.getValue() +
                                                 ((NumberLogMessage)previousLogMessage).getValue() -
                                                 maxValue);

            numberLogMessage.setValue(maxValue);
            printer.printOut(formatterVisitor.formatLogMessage(numberLogMessage));

            return accumulatedNumberLogMessage;
        }

        if (numberLogMessage.getValue() + ((NumberLogMessage)previousLogMessage).getValue() <= minValue) {
            accumulatedNumberLogMessage.setValue(numberLogMessage.getValue() +
                                                 ((NumberLogMessage)previousLogMessage).getValue() -
                                                 minValue);

            numberLogMessage.setValue(minValue);
            printer.printOut(formatterVisitor.formatLogMessage(numberLogMessage));

            return accumulatedNumberLogMessage;
        }

        accumulatedNumberLogMessage.setValue(((NumberLogMessage)previousLogMessage).getValue() +
                                             numberLogMessage.getValue());

        return accumulatedNumberLogMessage;
    }
}