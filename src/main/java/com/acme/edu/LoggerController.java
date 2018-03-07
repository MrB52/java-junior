package com.acme.edu;

import com.acme.edu.message.IntLogMessage;
import com.acme.edu.message.LogMessage;
import com.acme.edu.message.StringLogMessage;
import com.acme.edu.prefix.*;
import com.acme.edu.printer.Printer;

/**
 * <code>LoggerController</code> - класс для логирования сообщений в консоль. Содержит один перегруженный метод log() для
 * логирования сообщений соответствующего типа.
 */

public class LoggerController {
    private PrefixAdder prefixAdder; //TODO внети в реализации LogMessage
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

    public void log(byte message) {
        prefixAdder = new PrimitivePrefixAdder();

        MessageState.setByteMessageState(message);
        printer.printOut(prefixAdder.addPrefix() + MessageState.getByteMessageState());
    }

    public void log(IntLogMessage intLogMessage) {
        if(previousLogMessage == null || !intLogMessage.isTypeMatched(previousLogMessage)) {
            previousLogMessage = intLogMessage;
//            return; //TODO а надо ли оно?
        } else {
            previousLogMessage = new IntLogMessage(intLogMessage.getAccumulatedValue() +
                    ((IntLogMessage)previousLogMessage).getAccumulatedValue());
        }
        if(!intLogMessage.isTypeMatched(previousLogMessage)) {
            printer.printOut(previousLogMessage.toString());
        }
    }

    public void log(int[] message) {
        prefixAdder = new PrimitiveArrayPrefixAdder();
        StringBuilder bufferedMessage = new StringBuilder("{");

        if (message.length > 0) {
            for (int i = 0; i < message.length-1; i++) {
                bufferedMessage.append(message[i]).append(", ");
            }
            bufferedMessage.append(message[message.length - 1]);
        }
        bufferedMessage.append("}");

        printer.printOut(prefixAdder.addPrefix() + bufferedMessage);
    }

    public void log(int[][] message) {
        prefixAdder = new PrimitiveMatrixPrefixAdder();
        StringBuilder bufferedMessage = new StringBuilder("{\n");

        if(message.length > 0){
            for (int[] element : message) {
                bufferedMessage.append("{");

                for (int j = 0; j < element.length - 1; j++) {
                    bufferedMessage.append(element[j]).append(", ");
                }

                bufferedMessage.append(element[element.length - 1]).append("}\n");
            }
        }
        bufferedMessage.append("}");

        printer.printOut(prefixAdder.addPrefix() + bufferedMessage);
    }

    public void log(boolean message) {
        prefixAdder = new PrimitivePrefixAdder();
        printer.printOut(prefixAdder.addPrefix() + message);
    }

    public void log(char message) {
        prefixAdder = new CharPrefixAdder();
        printer.printOut(prefixAdder.addPrefix() + message);
    }

    public void log(StringLogMessage stringLogMessage) {
        if(previousLogMessage == null || !stringLogMessage.isTypeMatched(previousLogMessage)) {
            previousLogMessage = stringLogMessage;
        }

//        prefixAdder = new StringPrefixAdder();
//
//        MessageState.setStringMessageState(message);
//        printer.printOut(prefixAdder.addPrefix() + MessageState.getStringMessageState());
    }

    public void log(Object message) {
        prefixAdder = new ReferencePrefixAdder();
        printer.printOut(prefixAdder.addPrefix() + message);
    }
}