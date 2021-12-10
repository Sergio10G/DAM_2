package com.campusfp.hitoftp.resources;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class FileReceiver extends Thread {
	private final int BUF_SIZE = 32000;
	
	//	Attributes
	private Socket socket;
	private FileManager fileManager;
	private List<byte[]> fileContent;
	
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
			if (serverMsg == 1) {
				outStream.writeInt(1);
				String fileName = inStream.readUTF();

				while (inStream.readInt() == 1) {
					byte[] buf = new byte[BUF_SIZE];
					inStream.read(buf);
					fileContent.add(buf);
				}

				if (fileManager.createFile(fileName, fileContent)) {
					System.out.println("Fichero transmitido con éxito!");
				}
				else {
					System.out.println("Ha habido algún error al crear el archivo.");
				}

				inStream.close();
				outStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//	Getters & Setters
	
	
}
