package com.sdiezg.ofertademanda;

public class Consumidor extends Thread {
	//	Attributes
	private Almacen almacen;
	private boolean activo;
	
	//	Constructors
	public Consumidor(Almacen almacen) {
		super.run();
		this.almacen = almacen;
		this.activo = true;
	}
	
	//	Methods
	@Override
	public void run() {
		while (activo) {
			if (almacen.getStock() > 0){
				synchronized (almacen) {
					almacen.consumirProducto();
				}
				try {
					sleep((int) (Math.random() * 1000 + 1));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				synchronized (almacen) {
					try {
						almacen.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println("CONSUMIDOR PARADO.");
	}
	
	//	Getters & Setters
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
