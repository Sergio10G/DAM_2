package com.sdiezg.tcp.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
			ServerSocket serverSocket = new ServerSocket(5111);
			System.out.println("Server listening...");
			Socket socket = serverSocket.accept();
			System.out.println("Client accepted");
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			
			String mensaje = inStream.readUTF();
			System.out.println(mensaje);
			
			outStream.writeUTF("Mensaje recibido");

			inStream.close();
			outStream.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
}
