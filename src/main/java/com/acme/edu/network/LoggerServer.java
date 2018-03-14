package com.acme.edu.network;

import com.acme.edu.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoggerServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {

            try (Socket session = serverSocket.accept();
                 ObjectInputStream serverInput = new ObjectInputStream(session.getInputStream());
                 ObjectOutputStream serverOutput = new ObjectOutputStream(session.getOutputStream())) {

                Logger.log((Integer)serverInput.readObject());//int
                Logger.log((Integer)serverInput.readObject());//int
                Logger.log((Byte)serverInput.readObject());//byte
                Logger.log((Byte)serverInput.readObject());//byte
                Logger.log((String)serverInput.readObject());//string
                Logger.log((int[])serverInput.readObject());//int[]
                Logger.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
