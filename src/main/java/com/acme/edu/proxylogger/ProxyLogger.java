package com.acme.edu.proxylogger;

public interface ProxyLogger {
    void log(byte message);

    void log(int message);

    void log(int[] message);

    void log(int[][] message);

    void log(boolean message);

    void log(char message);

    void log(String message);

    void log(Object message);
}
