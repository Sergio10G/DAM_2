package com.sergio10g.carrera;

import java.util.Random;

public class Correr extends Thread {
	//	Attributes
	private Corredor cor;
	private int meta;
	private Posicion pos;

	//	Constructors
	public Correr(Corredor cor, int meta, Posicion pos) {
		super();
		this.cor = cor;
		this.meta = meta;
		this.pos = pos;
	}
	
	//	Methods
	@Override
	public void run() {
		int distancia = 0;
		Random r = new Random();
		while (distancia < meta) {
			distancia += r.nextInt(meta / 10);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(cor.getNombre() + " ha llegado a la meta en posición número " + pos.getPos());
		cor.setLugar(pos.getPos());
		pos.setPos(pos.getPos() + 1);
		
	}
	
	//	Getters & Setters
	public Corredor getCor() {
		return cor;
	}

	public void setCor(Corredor cor) {
		this.cor = cor;
	}

	public int getMeta() {
		return meta;
	}

	public void setMeta(int meta) {
		this.meta = meta;
	}

	public Posicion getPos() {
		return pos;
	}

	public void setPos(Posicion pos) {
		this.pos = pos;
	}
	
}
