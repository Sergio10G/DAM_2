package com.campusfp.veterinaria.model;

public class Propietario extends SerHumano{
	//	Attributes
	private String email;
	private Mascota mascotas[];
	private int num_mascotas;
	
	//	Constructors
	public Propietario(String nombre, String email) {
		super(nombre);
		this. email = email;
		this.mascotas = new Mascota[10];
		this.num_mascotas = 0;
	}
	
	//	Methods
	@Override
	public void hablar() {
		System.out.println("Hola, soy " + super.getNombre());
	}

	public void addMascota(Mascota m) {
		if (this.num_mascotas < 10)
		{
			this.mascotas[this.num_mascotas] = m;
			this.num_mascotas++;
		}
		else
			System.out.println("No se pueden introducir más mascotas," + 
			" número máximo alcanzado.");
	}

	public void rmMascota(int index)
	{
		if (this.num_mascotas > 0 && index >= 0 && index < this.num_mascotas)
		{
			for (; index < this.num_mascotas - 1; index++)
				this.mascotas[index] = this.mascotas[index + 1];
			this.mascotas[index] = null;
			this.num_mascotas--;
		}
	}
	
	//	Getters & Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
