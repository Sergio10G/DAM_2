package com.sergio10g.main;

import java.util.ArrayList;
import java.util.List;

import com.sergio10g.clases.HiloTemporizador;
import com.sergio10g.clases.ListaTemporizador;

public class Main {
	public static void main(String[] args) {
		List<HiloTemporizador> lista = new ArrayList<>();

		lista.add(new HiloTemporizador(1, 10));
		lista.add(new HiloTemporizador(2, 5));
		lista.add(new HiloTemporizador(3, 15));
		lista.add(new HiloTemporizador(4, 10));
		
		ListaTemporizador pt = new ListaTemporizador(lista);
		
		System.out.println("Empezamos " + lista.size() + " temporizadores.");
		pt.start();
		try {
			pt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Acabaron todos los temporizadores!");
	}
}
