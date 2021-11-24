package com.sdiezg.classes.app;

import java.net.DatagramPacket;
import java.net.InetAddress;

import com.sdiezg.classes.game.Player;

public class Client {
	//	Attributes
	private InetAddress ip;
	private int port;
	private Player player;

	//	Constructors
	public Client(DatagramPacket dp) {
		this.ip = dp.getAddress();
		this.port = dp.getPort();
	}
	
	//	Methods
	@Override
	public String toString() {
		return "Client [ip=" + ip + ", player=" + player + ", port=" + port + "]";
	}
	
	//	Getters & Setters
	public InetAddress getIp() {
		return ip;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
