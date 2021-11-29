package com.sdiezg.classes.app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class DataSender {
	//	Attributes
	private DatagramSocket socket;
	private List<Client> clients;
	private boolean active;
	 
	//	Constructors
	public DataSender(DatagramSocket socket) {
		this.socket = socket;
		this.clients = new ArrayList<Client>();
		this.active = true;
	}
	
	//	Methods
	public void sendAll(String data) {
		for (Client client : clients) {	
			byte[] buf = new byte[1024];
			buf = data.getBytes();
			DatagramPacket p = new DatagramPacket(buf, buf.length, client.getIp(), client.getPort());
			try {
				socket.send(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void sendToClient(Client client, String data) {
		
	}
	
	//	Getters & Setters
	
	
}
