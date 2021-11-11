package com.sdiezg.udp.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class Servidor extends Thread{
	//	Attributes
	private DatagramSocket socket;

	//	Constructors
	public Servidor(DatagramSocket socket) {
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
		String nombre = "Servidor";
		Scanner sc = new Scanner(System.in);
		byte[] buf = new byte[1024];
		try {
			DatagramSocket socket = new DatagramSocket(5111);
			
			DatagramPacket p1 = new DatagramPacket(buf, buf.length);
			socket.receive(p1);
			String m = new String(p1.getData());
			if (!m.trim().equals("1")) 
				return;
			
			Servidor receptor = new Servidor(socket);
			receptor.start();
			
			System.out.println("Bienvenido al chat, escribe algo!");
			while (true) {
				String mensaje = nombre + ": " + sc.nextLine();
				buf = mensaje.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, p1.getAddress(), p1.getPort());
				socket.send(packet);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//	Getters & Setters
	
}
