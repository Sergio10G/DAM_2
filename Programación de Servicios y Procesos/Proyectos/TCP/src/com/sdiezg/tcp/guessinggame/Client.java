package com.sdiezg.tcp.guessinggame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Socket socket = new Socket("192.168.101.115", 5111);
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Introduce tu nombre: ");
			outStream.writeUTF(sc.nextLine());

			String mensaje = inStream.readUTF();
			System.out.println(mensaje);

			while (true) {
				System.out.println("Introduce un número: ");
				outStream.writeInt(Integer.parseInt(sc.nextLine()));
				String msg = inStream.readUTF();
				System.out.println(msg);
				if (inStream.readBoolean()) {
					break;
				}
			}
			System.out.println(inStream.readUTF());

			inStream.close();
			outStream.close();
			socket.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
