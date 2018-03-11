package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.printer.Printer;

/**
 * <code>LoggerController</code> - класс для логирования сообщений в консоль. Содержит один перегруженный метод log() для
 * логирования сообщений соответствующего типа.
 */

public class LoggerController {
    private LogMessage previousLogMessage;
    private Printer printer;

    public LoggerController(Printer printer) {
        this.printer = printer;
    }

    public LogMessage getPreviousLogMessage() {
        return previousLogMessage;
    }

    public void setPreviousLogMessage(LogMessage previousLogMessage) {
        this.previousLogMessage = previousLogMessage;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void log(ByteLogMessage message) {
        checkReadinessForPrintOut(message);

        if (checkAccumulatingNecessity(message)) {
            previousLogMessage = new ByteLogMessage(((ByteLogMessage)previousLogMessage).getValue() +
                    message.getValue());
        }
    }

    public void log(IntLogMessage message) {
        checkReadinessForPrintOut(message);

        if (checkAccumulatingNecessity(message)) {
            if (checkNumberUpperBorderOverflow(message, Integer.MAX_VALUE)) {
                previousLogMessage = new IntLogMessage(((IntLogMessage)previousLogMessage).getValue() +
                                                       message.getValue() - Integer.MAX_VALUE);
                return;
            }

            if (checkNumberLowerBorderOverflow(message, Integer.MIN_VALUE)) {
                previousLogMessage = new IntLogMessage(((IntLogMessage)previousLogMessage).getValue() +
                        message.getValue() - Integer.MIN_VALUE);
                return;
            }

            previousLogMessage = new IntLogMessage(((IntLogMessage)previousLogMessage).getValue() +
                    message.getValue());
        }
    }

    public void log(IntArrayLogMessage message) {
        printer.printOut(message);
    }

    public void log(IntMatrixLogMessage message) {
        printer.printOut(message);
    }

    public void log(BooleanLogMessage message) {
        printer.printOut(message);
    }

    public void log(CharLogMessage message) {
        printer.printOut(message);
    }

    public void log(StringLogMessage message) {
        checkReadinessForPrintOut(message);

        if (checkAccumulatingNecessity(message)) {
            //TODO add body
        }
    }

    public void log(ReferenceLogMessage message) {
        printer.printOut(message);
    }

    private void checkReadinessForPrintOut(LogMessage message) {
        if (previousLogMessage != null && !message.isTypeMatched(previousLogMessage)) {
            printer.printOut(previousLogMessage);
        }
    }

    private boolean checkAccumulatingNecessity(LogMessage message) {
        if (previousLogMessage == null || !message.isTypeMatched(previousLogMessage)) {
            previousLogMessage = message;
            return false;
        }
        return true;
    }

    private boolean checkNumberUpperBorderOverflow(NumberLogMessage numberLogMessage, long maxValue) {
        if (numberLogMessage.getValue() + ((NumberLogMessage)previousLogMessage).getValue() >= maxValue) {
            numberLogMessage.setUpperOverflowStatus(true);
            printer.printOut(numberLogMessage);
            return true;
        }

        return false;
    }

    private boolean checkNumberLowerBorderOverflow(NumberLogMessage numberLogMessage, long minValue) {
        if (numberLogMessage.getValue() + ((NumberLogMessage)previousLogMessage).getValue() <= minValue) {
            numberLogMessage.setLowerOverflowStatus(true);
            printer.printOut(numberLogMessage);
            return true;
        }

        return false;
    }
}