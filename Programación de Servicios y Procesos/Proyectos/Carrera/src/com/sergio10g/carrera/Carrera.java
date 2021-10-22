package com.sergio10g.carrera;

import java.util.List;

public class Carrera extends Thread {
	//	Attributes
	private List<Correr> corredores;
	
	//	Constructors
	public Carrera(List<Correr> corredores) {
		super();
		this.corredores = corredores;
	}
	
	//	Methods
	@Override
	public void run() {
		for (Correr c : corredores)
			c.start();
		for (Correr c : corredores)
			try {
				c.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("La carrera se acabó.");		
	}
	
	//	Getters & Setters
	
	
}
