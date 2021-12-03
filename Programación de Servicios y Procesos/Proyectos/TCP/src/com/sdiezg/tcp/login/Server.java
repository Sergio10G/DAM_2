package com.sdiezg.tcp.login;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static HashMap<String, String> users;
	public static void main(String[] args) {
		users = new HashMap<String, String>();
		try {
			ServerSocket serverSocket = new ServerSocket(5111);
			System.out.println("SERVIDOR [  " + ANSI_GREEN + "ACTIVO" + ANSI_RESET + "  ]" + "\nEsperando clientes...");
			while (true) {
				Socket socket = serverSocket.accept();
				ClientRoutine cr = new ClientRoutine(socket, users);
				cr.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
