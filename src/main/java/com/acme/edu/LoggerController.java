package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.printer.Printer;
import com.acme.edu.visitor.FormatterVisitor;

public class LoggerController {
    private LogMessage previousLogMessage;
    private Printer printer;

    public LoggerController(Printer printer) {
        this.printer = printer;
    }

    public void log(ByteLogMessage message, FormatterVisitor formatterVisitor) {
        checkReadinessForPrintOut(message, formatterVisitor);

        if (checkAccumulatingNecessity(message)) {

            if (checkNumberUpperBorderOverflow(message, Byte.MAX_VALUE, formatterVisitor)) {
                previousLogMessage = new ByteLogMessage(((ByteLogMessage)previousLogMessage).getValue() +
                                                        message.getValue() - Byte.MAX_VALUE);
                return;
            }

            if (checkNumberLowerBorderOverflow(message, Byte.MIN_VALUE, formatterVisitor)) {
                previousLogMessage = new ByteLogMessage(((ByteLogMessage)previousLogMessage).getValue() +
                                                        message.getValue() - Byte.MIN_VALUE);
                return;
            }

            previousLogMessage = new ByteLogMessage(((ByteLogMessage)previousLogMessage).getValue() +
                                                    message.getValue());
        }
    }

    public void log(IntLogMessage message, FormatterVisitor formatterVisitor) {
        checkReadinessForPrintOut(message, formatterVisitor);

        if (checkAccumulatingNecessity(message)) {

            if (checkNumberUpperBorderOverflow(message, Integer.MAX_VALUE, formatterVisitor)) {
                previousLogMessage = new IntLogMessage(((IntLogMessage)previousLogMessage).getValue() +
                                                       message.getValue() - Integer.MAX_VALUE);
                return;
            }

            if (checkNumberLowerBorderOverflow(message, Integer.MIN_VALUE, formatterVisitor)) {
                previousLogMessage = new IntLogMessage(((IntLogMessage)previousLogMessage).getValue() +
                                                       message.getValue() - Integer.MIN_VALUE);
                return;
            }

            previousLogMessage = new IntLogMessage(((IntLogMessage)previousLogMessage).getValue() +
                                                   message.getValue());
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

    private boolean checkNumberUpperBorderOverflow(NumberLogMessage numberLogMessage, long maxValue, FormatterVisitor formatterVisitor) {
        if (numberLogMessage.getValue() + ((NumberLogMessage)previousLogMessage).getValue() >= maxValue) {
            numberLogMessage.setUpperOverflowStatus(true);
            printer.printOut(formatterVisitor.formatLogMessage(numberLogMessage));
            return true;
        }

        return false;
    }

    private boolean checkNumberLowerBorderOverflow(NumberLogMessage numberLogMessage, long minValue, FormatterVisitor formatterVisitor) {
        if (numberLogMessage.getValue() + ((NumberLogMessage)previousLogMessage).getValue() <= minValue) {
            numberLogMessage.setLowerOverflowStatus(true);
            printer.printOut(formatterVisitor.formatLogMessage(numberLogMessage));
            return true;
        }

        return false;
    }
}