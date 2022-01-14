package com.sdiezg.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) {
		try {
			Calculadora calc = new Calculadora();
			LocateRegistry.createRegistry(5031);
			Naming.rebind("rmi://localhost:5031/calculadora", calc);
			System.out.println("Server escuchando...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
