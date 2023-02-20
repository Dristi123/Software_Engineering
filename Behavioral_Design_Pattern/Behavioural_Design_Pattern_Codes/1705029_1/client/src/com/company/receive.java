package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class receive implements Runnable {
    public static Socket clientSocket;

    public receive(Socket s) throws Exception {
        this.clientSocket = s;
    }

    @Override
    public void run() {
        try {

            String modifiedSentence;
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (true) {
                modifiedSentence = inFromServer.readLine();
                System.out.println(modifiedSentence);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
