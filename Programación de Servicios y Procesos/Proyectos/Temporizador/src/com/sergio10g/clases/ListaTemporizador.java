package com.sergio10g.clases;

import java.util.List;

public class ListaTemporizador extends Thread{
	//	Attributes
	private List<HiloTemporizador> lista;
	
	//	Constructors
	public ListaTemporizador(List<HiloTemporizador> lista) {
		super();
		this.lista = lista;
	}
	
	//	Methods
	@Override
	public void run() {
		for (HiloTemporizador ht : lista)
			ht.start();
		for (HiloTemporizador ht : lista)
			try {
				ht.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	//	Getters & Setters
	
	
}
