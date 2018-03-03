package com.acme.edu;

import com.acme.edu.prefix.CharPrefixAdder;
import com.acme.edu.prefix.PrefixAdder;
import com.acme.edu.prefix.PrimitivePrefixAdder;
import com.acme.edu.prefix.ReferencePrefixAdder;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.Printer;

public class ConsoleProxyLogger {
    private PrefixAdder prefixAdder;
    private Printer printer = new ConsolePrinter();

    public void log(char message) {
        prefixAdder = new CharPrefixAdder();
        printer.printOut(prefixAdder.addPrefix() + message);
    }

    public void log(boolean message) {
        prefixAdder = new PrimitivePrefixAdder();
        printer.printOut(prefixAdder.addPrefix() + message);
    }

    public void log(Object message) {
        prefixAdder = new ReferencePrefixAdder();
        printer.printOut(prefixAdder.addPrefix() + message);
    }
}