package com.campusfp.hitoftp.resources;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;

public class FileSender extends Thread {
	private final int BUF_SIZE = 16000;
	
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
	
			System.out.println("Sender sending 1");
			outStream.writeInt(1);
			int response = inStream.readInt();
			System.out.println("Sender received " + response);
			if (response == 1) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				outStream.writeUTF(file.getName());
				System.out.println("Sender sending " + file.getName());

				int off = 0;
				String fileContent = "";
				String line = "";
				while ((line = br.readLine()) != null) {
					fileContent += line;
				}

				boolean finished = false;
				while (!finished) {

					String msg = "";
					int passedChars = 0;
					while (passedChars < BUF_SIZE) {
						if (passedChars + (off * BUF_SIZE) >= fileContent.length()) {
							finished = true;
							break;
						}
						msg += fileContent.charAt(passedChars + (off * BUF_SIZE));
						passedChars++;
					}
					
					if (!msg.equals("")) {
						outStream.writeInt(1);
						outStream.writeUTF(msg);
					}
				}
				/*
					byte[] fileContent = Files.readAllBytes(file.toPath());
					int offsetMult = 0;
					int sentChars = 0;

					while (sentChars < fileContent.length) {
						System.out.println("Sending file content");
						byte[] packetContent = new byte[BUF_SIZE];
						int passedChars = 0;
						while (passedChars < BUF_SIZE) {
							if (passedChars + (offsetMult * BUF_SIZE) >= fileContent.length){
								break;
							}
							packetContent[passedChars] = fileContent[passedChars + (offsetMult * BUF_SIZE)];
							passedChars++;
						}
						outStream.writeInt(1);
						outStream.write(packetContent);
						sentChars += passedChars;
					}
				*/
				System.out.println("Sender finished");
				outStream.writeInt(0);

				br.close();
				//inStream.close();
				//outStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//	Getters & Setters
	
	
}
