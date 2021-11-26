package com.sdiezg.tcp.guessinggame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceiver extends Thread {
	//	Attributes
	private Socket socket;
	private Juego juego;
	
	//	Constructors
	public ClientReceiver(Socket socket, Juego juego) {
		this.socket = socket;
		this.juego = juego;
	}
	
	//	Methods
	@Override
	public void run() {
		try {
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			String jugador = inStream.readUTF();
			System.out.println("Jugador conectado: " + jugador);
			juego.setNumPlayers(juego.getNumPlayers() + 1);
			synchronized (juego) {
				juego.wait();
			}
			outStream.writeUTF("Iniciando juego");
			boolean ganador = false;

			while (true) {
				synchronized (juego) {
					int num = inStream.readInt();
					if (num < juego.getSecretNum())
						outStream.writeUTF("El numero es mayor.");
					else if (num > juego.getSecretNum())
						outStream.writeUTF("El numero es menor.");
					else {
						outStream.writeUTF("Felicidades, has ganado.");
						juego.setFin(true);
						ganador = true;
					}
					if (juego.isFin())
						break;
				}
				sleep(3000);
				outStream.writeBoolean(juego.isFin());
			}

			if (ganador)
				System.out.println(jugador + " ha ganado.");
			else
				outStream.writeUTF("HAS PERDIDO");
			outStream.writeUTF("JUEGO TERMINADO");

			inStream.close();
			outStream.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//	Getters & Setters
	
	
}
