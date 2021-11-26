package com.sdiezg.tcp.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 5111);
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

			outStream.writeUTF("Yo waddup");
			
			String mensaje = inStream.readUTF();
			System.out.println(mensaje);

			inStream.close();
			outStream.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
