package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.prefix.*;
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

    public void log(ByteLogMessage message) {
        printer.printOut(message.toString());
    }

    public void log(IntLogMessage message) {
        printer.printOut(message.toString());
    }

    public void log(IntArrayLogMessage message) {
        printer.printOut(message.toString());
    }

    public void log(IntMatrixLogMessage message) {
        printer.printOut(message.toString());
    }

    public void log(BooleanLogMessage message) {
        printer.printOut(message.toString());
    }

    public void log(CharLogMessage message) {
        printer.printOut(message.toString());
    }

    public void log(StringLogMessage message) {
        printer.printOut(message.toString());
    }

    public void log(ReferenceLogMessage message) {
        printer.printOut(message.toString());
    }
}