package com.sdiezg.tcp.login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int optInt = 0;
			Socket socket = new Socket("127.0.0.1", 5111);
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			// Mensaje de bienvenida
			System.out.println(inStream.readUTF());
			while (true) {
				String opt = sc.nextLine();
				try {
					optInt = Integer.parseInt(opt);
					if (optInt != 1 && optInt != 2) {
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.println("La opcion introducida es incorrecta. Introduzca una opción válida: ");
					continue;
				}
				break;
			}
			// Elección
			outStream.writeInt(optInt);
			
			// Email
			System.out.println(inStream.readUTF());
			outStream.writeUTF(sc.nextLine());
			// Pass
			System.out.println(inStream.readUTF());
			outStream.writeUTF(sc.nextLine());

			// Resultado
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
