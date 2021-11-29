package com.sdiezg.tcp.login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ClientRoutine extends Thread {
	//	Attributes
	private HashMap<String, String> users;
	private Socket socket;
	
	//	Constructors
	public ClientRoutine(Socket socket, HashMap<String, String> users) {
		this.socket = socket;
		this.users = users;
	}
	
	//	Methods
	@Override
	public void run() {
		try {
			System.out.println("Cliente conectado");

			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			
			outStream.writeUTF("Bienvenido al servidor. ¿Qué desea hacer?\n1. Login\n2. Registro");
			int option = inStream.readInt();
			outStream.writeUTF("Introduzca su correo electrónico: ");
			String email = inStream.readUTF();
			outStream.writeUTF("Introduzca su contraseña: ");
			String pass = inStream.readUTF();
			
			if (option == 1) {
				if (users.containsKey(email) && users.get(email).equals(pass)) {
					outStream.writeUTF("Inicio de sesión correcto!");
				}
				else {
					outStream.writeUTF("Error, algún dato introducido no era correcto.");
				}
			}
			else if (option == 2) {
				if (!users.containsKey(email)) {
					synchronized (users) {
						users.put(email, pass);
					}
					outStream.writeUTF("Registro completado!");
				}
				else {
					outStream.writeUTF("Error, ya existe un usuario registrado con este correo.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//	Getters & Setters
	
	
}
