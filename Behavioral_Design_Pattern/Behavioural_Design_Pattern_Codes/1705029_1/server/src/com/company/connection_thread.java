package com.company;

import Observer.Observer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class connection_thread implements Runnable {
    ServerSocket ws;

    public connection_thread(ServerSocket ss) {
        this.ws = ss;
    }

    @Override
    public void run() {
        while (true) {
            Socket connectionsocket = null;
            try {
                connectionsocket = ws.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Observer tc = new Observer(connectionsocket);
            tc.start();
        }
    }
}
