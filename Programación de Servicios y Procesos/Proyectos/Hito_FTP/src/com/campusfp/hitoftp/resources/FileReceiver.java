package com.campusfp.hitoftp.resources;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class FileReceiver extends Thread {
	
	//	Attributes
	private Socket socket;
	private FileManager fileManager;
	//private List<byte[]> fileContent;
	private List<String> fileContent;
	
	//	Constructors
	public FileReceiver(Socket socket, FileManager fileManager) {
		this.socket = socket;
		this.fileManager = fileManager;
		this.fileContent = new ArrayList<>();
	}
	
	//	Methods
	@Override
	public void run() {
		try {
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
	
			int serverMsg = inStream.readInt();
			System.out.println("Receiver received " + serverMsg);
			if (serverMsg == 1) {
				System.out.println("Receiver sending 1");
				outStream.writeInt(1);
				String fileName = inStream.readUTF();
				System.out.println("Receiver received " + fileName);

				while (inStream.readInt() == 1) {
					String msg = inStream.readUTF();
					fileContent.add(msg);
					System.out.println("Reading file content...");
				}

				if (fileManager.createFile(fileName, fileContent)) {
					System.out.println("Fichero transmitido con éxito!");
				}
				else {
					System.out.println("Ha habido algún error al crear el archivo.");
				}

				/*
					while (inStream.readInt() == 1) {
						byte[] buf = new byte[BUF_SIZE];
						inStream.read(buf);
						fileContent.add(buf);
						System.out.println("Reading file content...");
					}

					if (fileManager.createFile(fileName, fileContent)) {
						System.out.println("Fichero transmitido con éxito!");
					}
					else {
						System.out.println("Ha habido algún error al crear el archivo.");
					}
				*/

				System.out.println("Receiver finished");

				//inStream.close();
				//outStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//	Getters & Setters
	
	
}
