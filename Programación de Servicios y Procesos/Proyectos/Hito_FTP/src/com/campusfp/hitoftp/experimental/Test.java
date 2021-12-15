package com.campusfp.hitoftp.experimental;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5111);

			TestSend client = new TestSend();
			client.start(); 
			
			Socket socket = serverSocket.accept();

			DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			
			System.out.println(inStream.readUTF());
			Thread.sleep(1000);
			System.out.println(inStream.readUTF());
			System.out.println("Finished listening");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
