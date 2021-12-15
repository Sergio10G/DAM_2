package com.campusfp.hitoftp.resources;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;

public class FileSender extends Thread {
	private final int BUF_SIZE = 32000;
	
	//	Attributes
	private Socket socket;
	private File file;
	
	//	Constructors
	public FileSender(Socket socket, File file) {
		this.socket = socket;
		this.file = file;
	}
	
	//	Methods
	@Override
	public void run() {
		try {
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
	
			outStream.writeInt(1);
			int response = inStream.readInt();
			if (response == 1) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				outStream.writeUTF(file.getName());

				boolean keepSending = true;
				// TODO: Cambiar la movida esta al otro read
				while (keepSending) {
					char readChar = 0;
					int readCharNum = 0;
					String msg = "";
					
					while ((readChar = (char) br.read()) != -1 && readCharNum < BUF_SIZE) {
						msg += readChar;
						readCharNum++;
					}
					byte[] buf = msg.getBytes();
					outStream.writeInt(1);
					outStream.write(buf);
					if (readCharNum != BUF_SIZE) {
						keepSending = false;
					}
				}
				outStream.writeInt(0);

				br.close();
				inStream.close();
				outStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//	Getters & Setters
	
	
}
