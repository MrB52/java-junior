package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.printer.Printer;

/**
 * <code>LoggerController</code> - класс для логирования сообщений в консоль. Содержит один перегруженный метод log() для
 * логирования сообщений соответствующего типа.
 */

public class LoggerController {
    private LogMessage previousLogMessage;
    private LogMessage bufferMessage;
    private boolean lower = false;
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

        if (isAccumulatingNeeded(message)) {
            previousLogMessage = new ByteLogMessage(((ByteLogMessage)previousLogMessage).getAccumulatedValue() +
                    message.getAccumulatedValue());
        }
    }

    public void log(IntLogMessage message) {
        checkReadinessForPrintOut(message);

        if (isAccumulatingNeeded(message)) {
            previousLogMessage = new IntLogMessage(((IntLogMessage) previousLogMessage).getAccumulatedValue() +
                    message.getAccumulatedValue());
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

        if (isAccumulatingNeeded(message)) {
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

    private boolean isAccumulatingNeeded(LogMessage message) {
        if (previousLogMessage == null || !message.isTypeMatched(previousLogMessage)) {
            previousLogMessage = message;
            return false;
        }
        return true;
    }
}