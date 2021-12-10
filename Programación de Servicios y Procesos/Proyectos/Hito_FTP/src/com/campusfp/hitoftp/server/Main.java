package com.campusfp.hitoftp.server;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.campusfp.hitoftp.resources.FileManager;

public class Main {

    List<File> loadedFiles;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1710);
            FileManager fileManager = new FileManager("./serverfiles");

            while (true) {
                Socket socket = serverSocket.accept();

				ClientRoutine cr = new ClientRoutine(socket, fileManager);
				cr.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
