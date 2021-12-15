package com.campusfp.hitoftp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.campusfp.hitoftp.resources.FileManager;

public class Main {

    public static void main(String[] args) {
        try {
            int clientNum = 0;
            ServerSocket serverSocket = new ServerSocket(5111);
            FileManager fileManager = new FileManager("./serverfiles");

            while (true) {
                Socket socket = serverSocket.accept();

				ClientRoutine cr = new ClientRoutine(socket, fileManager, ++clientNum);
				cr.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
