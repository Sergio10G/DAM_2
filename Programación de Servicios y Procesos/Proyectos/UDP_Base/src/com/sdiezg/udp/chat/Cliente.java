package com.sdiezg.udp.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente extends Thread{
	//	Attributes
	private DatagramSocket socket;

	//	Constructors
	public Cliente(DatagramSocket socket) {
		super();
		this.socket = socket;
	}

	//	Methods
	@Override
	public void run() {
		byte[] buf;
		try {
			while (true) {
				buf = new byte[1024];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String mensaje = new String(packet.getData());
				System.out.println(mensaje);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		String nombre = "Cliente";
		byte[] buf;
		Scanner sc = new Scanner(System.in);
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket p1 = new DatagramPacket("1".getBytes(), 1, InetAddress.getByName("127.0.0.1"), 5111);
			socket.send(p1);
			Cliente receptor = new Cliente(socket);
			receptor.start();
			System.out.println("Bienvenido al chat, escribe algo!");
			while (true) {
				String mensaje = nombre + ": " + sc.nextLine();
				buf = mensaje.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 5111);
				socket.send(packet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
