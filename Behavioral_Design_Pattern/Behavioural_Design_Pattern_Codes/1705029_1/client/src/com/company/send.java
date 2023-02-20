package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class send implements Runnable {
    public Socket clientSocket;

    public send(Socket s) throws Exception {
        this.clientSocket = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            String sentence = null;
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            while (true) {
                sentence = inFromUser.readLine();
                if (sentence.equalsIgnoreCase("Exit")) {
                    clientSocket.close();
                    System.exit(0);
                }
                outToServer.println(sentence);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
