package com.campusfp.hitoftp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.campusfp.hitoftp.resources.FileManager;

public class ClientRoutine extends Thread{
    // ATTRIBUTES
    private Socket socket;
    private FileManager fileManager;
    
    // CONSTRUCTORS
    public ClientRoutine(Socket socket, FileManager fileManager) {
        this.socket = socket;
        this.fileManager = fileManager;
    }
    
    // METHDOS
    @Override
    public void run() {
        try {
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

            inStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // GETTERS AND SETTERS
    
    
}
