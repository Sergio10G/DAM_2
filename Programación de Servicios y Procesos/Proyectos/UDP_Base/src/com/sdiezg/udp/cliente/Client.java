package com.sdiezg.udp.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		byte[] buf;
		try {
			DatagramSocket socket = new DatagramSocket();
			String mensaje = "hola";
			buf = mensaje.getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 5111);
			System.out.println("Enviando mensaje...");
			socket.send(packet);
			buf = new byte[1024];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			mensaje = new String(packet.getData());
			System.out.println("Recibido: " + mensaje);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
