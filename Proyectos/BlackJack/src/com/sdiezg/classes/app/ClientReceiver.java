package com.sdiezg.classes.app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class ClientReceiver extends Thread{
	//	Attributes
	private DatagramSocket socket;
	private List<Client> clients;
	private boolean active;

	//	Constructors
	public ClientReceiver(DatagramSocket socket) {
		this.socket = socket;
		this.clients = new ArrayList<Client>();
		this.active = true;
	}
	
	//	Methods
	@Override
	public void run() {
		while (active) {
			byte[] buf = new byte[1024];
			DatagramPacket p = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(p);
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			System.out.println("Client received!");
			clients.add(new Client(p));
		}
	}
	
	@Override
	public String toString() {
		String s = "Received clients:\n";
		for (Client client : clients) {
			s += client + "\n";
		}
		return s;
	}

	//	Getters & Setters
	public void turnOff() {
		this.active = false;
	}
	
}
