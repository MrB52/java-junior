package com.acme.edu.proxylogger;

import com.acme.edu.MessageState;
import com.acme.edu.prefix.*;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.Printer;

/**
 * <code>ConsoleProxyLogger</code> - класс для логирования сообщений в консоль. Содержит один перегруженный метод log() для
 * логирования сообщений соответствующего типа.
 */

public class ConsoleProxyLogger implements ProxyLogger{
    private PrefixAdder prefixAdder;
    private Printer printer = new ConsolePrinter();

    @Override
    public void log(byte message) {
        prefixAdder = new PrimitivePrefixAdder();

        MessageState.setByteMessageState(message);
        printer.printOut(prefixAdder.addPrefix() + MessageState.getByteMessageState());
    }

    @Override
    public void log(int message) {
        prefixAdder = new PrimitivePrefixAdder();

        MessageState.setIntMessageState(message);
        printer.printOut(prefixAdder.addPrefix() + MessageState.getIntMessageState());
    }

    @Override
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

    @Override
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

    @Override
    public void log(boolean message) {
        prefixAdder = new PrimitivePrefixAdder();
        printer.printOut(prefixAdder.addPrefix() + message);
    }

    @Override
    public void log(char message) {
        prefixAdder = new CharPrefixAdder();
        printer.printOut(prefixAdder.addPrefix() + message);
    }

    @Override
    public void log(String message) {
        prefixAdder = new StringPrefixAdder();

        MessageState.setStringMessageState(message);
        printer.printOut(prefixAdder.addPrefix() + MessageState.getStringMessageState());
    }

    @Override
    public void log(Object message) {
        prefixAdder = new ReferencePrefixAdder();
        printer.printOut(prefixAdder.addPrefix() + message);
    }
}