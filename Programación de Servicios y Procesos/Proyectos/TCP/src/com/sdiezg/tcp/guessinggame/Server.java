package com.sdiezg.tcp.guessinggame;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
	public static void main(String[] args) {
		Juego juego = new Juego((new Random()).nextInt(100) + 1);
		try {
			ServerSocket serverSocket = new ServerSocket(5111);
			int jugadores = 0;
			while (true) {
				Socket socket = serverSocket.accept();
				ClientReceiver cr = new ClientReceiver(socket, juego);
				cr.start();
				jugadores++;
				System.out.println(jugadores);
				if (jugadores >= 15) {
					synchronized (juego) {
						juego.notifyAll();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
