package com.acme.edu;

import com.acme.edu.prefix.CharPrefixAdder;
import com.acme.edu.prefix.PrefixAdder;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.Printer;

public class ConsoleProxyLogger {
    private Printer printer ;
    private PrefixAdder prefixAdder;

    public void log(char message) {
        prefixAdder = new CharPrefixAdder();
        printer = new ConsolePrinter();

        printer.printOut(prefixAdder.addPrefix() + message);
    }
}
