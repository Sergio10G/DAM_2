package com.sdiezg.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.sdiezg.rmi.server.ICalculadora;

public class Cliente {
	public static void main(String[] args) {
		int n1 = 5, n2 = 10;
		try {
			Registry r = LocateRegistry.getRegistry(5031);
			ICalculadora ic = (ICalculadora) r.lookup("rmi://localhost:5031/calculadora");
			System.out.println(n1 + " + " + n2 + " = " + ic.suma(n1, n2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
