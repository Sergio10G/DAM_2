package com.sdiezg.ofertademanda;

public class Productor extends Thread {
	//	Attributes
	private Almacen almacen;
	private boolean activo;
	
	//	Constructors
	public Productor(Almacen almacen) {
		super.run();
		this.almacen = almacen;
		this.activo = true;
	}
	
	//	Methods
	@Override
	public void run() {
		while (activo) {
			synchronized (almacen) {
				almacen.generarProducto();
				almacen.notifyAll();
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("PRODUCTOR PARADO.");
	}
	
	//	Getters & Setters
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
