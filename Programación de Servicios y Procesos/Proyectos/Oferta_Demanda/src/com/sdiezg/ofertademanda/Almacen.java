package com.sdiezg.ofertademanda;

public class Almacen {
	//	Attributes
	private int stock;
	private float precio;
	private float ganancias;
	
	//	Constructors
	public Almacen() {
		this.stock = 100;
		this.precio = 10;
		this.ganancias = 0f;
	}
	
	//	Methods
	public void generarProducto() {
		this.stock += 1;
		System.out.println("Se crea un producto. Hay " + this.stock);
	}

	public void consumirProducto() {
		this.ganancias += this.getPrecio();
		this.stock -= 1;
		System.out.println("Se consume un producto. Hay " + this.stock);
		System.out.println("Ganancias hasta ahora: " + this.ganancias + "€");
	}
	
	//	Getters & Setters
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		float mod = 1f;
		if (this.stock < 50)
			mod = 1.2f;
		else if (this.stock < 10)
			mod = 1.5f;
		return precio * mod;
	}

	public float getGanancias() {
		return ganancias;
	}
	
}
