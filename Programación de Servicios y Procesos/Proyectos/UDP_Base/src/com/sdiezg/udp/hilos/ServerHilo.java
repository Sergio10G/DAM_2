package com.sdiezg.udp.hilos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerHilo extends Thread{
	//	Attributes
	private DatagramSocket socket;
	private DatagramPacket packet;
	private int id;

	//	Constructors
	public ServerHilo(DatagramSocket socket, DatagramPacket packet, int id) {
		super();
		this.socket = socket;
		this.packet = packet;
		this.id = id;
	}

	//	Methods
	@Override
	public void run() {
		byte[] buf = new byte[1024];
		try {
			String mensaje = "Respuesta a cliente " + id;
			buf = mensaje.getBytes();
			//Thread.sleep(30000);
			packet = new DatagramPacket(buf, buf.length, packet.getAddress(), packet.getPort());
			socket.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		try {
			int id = 1;
			DatagramSocket socket = new DatagramSocket(5111);
			byte[] buf = new byte[1024];
			while (true) {
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				System.out.println("Esperando mensaje...");
				socket.receive(packet);
				String mensaje = new String(packet.getData());
				System.out.println("Mensaje recibido: " + mensaje);
				ServerHilo sh = new ServerHilo(socket, packet, id++);
				sh.start();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//	Getters & Setters
	
	
}