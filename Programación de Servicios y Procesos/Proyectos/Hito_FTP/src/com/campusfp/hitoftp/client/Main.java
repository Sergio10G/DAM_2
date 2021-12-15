package com.campusfp.hitoftp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.campusfp.hitoftp.resources.FileManager;
import com.campusfp.hitoftp.resources.Menu;

public class Main {
	
	public static void main(String[] args) {
		Socket socket;
		Scanner sc = new Scanner(System.in);
		DataInputStream inStream;
		DataOutputStream outStream;
		FileManager fileManager;
		String ip;
		int port;

		System.out.println("Bienvenido al servicio de transferencia de archivos FTP");
		System.out.println("Introduce la ip del servidor (default 127.0.0.1):");
		ip = sc.nextLine();
		if (ip.equals(""))
			ip = "127.0.0.1";
		while (true) {
			System.out.println("Introduce el puerto (default 5111):");
			String portInput = sc.nextLine();
			try {
				if (portInput.equals(""))
					port = 5111;
				else
					port = Integer.parseInt(portInput);
				if (port < 1024 || port > 65535) {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("El puerto introducido es inválido.");
				continue;
			}
			break;
		}

		

		try {
			socket = new Socket(ip, port);

			inStream = new DataInputStream(socket.getInputStream());
			outStream = new DataOutputStream(socket.getOutputStream());

			fileManager = new FileManager("./clientfiles");
			Menu menu = new Menu();
			String category = "main";
			int pick = -1;

			while (true) {
				String serverMsg = inStream.readUTF();
				System.out.println(serverMsg);

				category = serverMsg.split("/")[0];

				if (category.equals("startDownload") || category.equals("startUpload")) {
				
					break;
				}
				else if (category.equals("listUpload")) {
					serverMsg = menu.refreshOptionsList(category, fileManager.getFileNames());
				}

				menu.printMenuFromText(serverMsg);
				
				pick = Integer.parseInt(sc.nextLine());
				outStream.writeInt(pick);

				if (category.equals("main") && pick == 0) {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 

		sc.close();
	}
}
