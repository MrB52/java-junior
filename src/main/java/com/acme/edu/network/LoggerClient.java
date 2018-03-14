package com.acme.edu.network;

import java.io.*;
import java.net.Socket;

public class LoggerClient {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 7777);
             ObjectOutputStream clientOutput = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream clientInput = new ObjectInputStream(clientSocket.getInputStream())) {

                clientOutput.writeObject(1);
                clientOutput.writeObject(10);
                clientOutput.writeObject((byte) 20);
                clientOutput.writeObject((byte) 30);
                clientOutput.writeObject("H");
                clientOutput.writeObject(new int[] {1, 2, 3});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
