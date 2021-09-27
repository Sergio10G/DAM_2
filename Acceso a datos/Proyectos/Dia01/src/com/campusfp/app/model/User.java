package com.campusfp.app.model;

import java.util.Date;

public class User {
	//	Attributes
	private String	email;
	private String	nombre;
	private String	dni;
	private Date	desde;
	private Address	address;
	
	//	Constructors
	public User(String email, String nombre, String dni) {
		this.email = email;
		this.nombre = nombre;
		this.dni = dni;
		this.desde = new Date();
	}

	public User(String email, String nombre, String dni, Address address) {
		this.email = email;
		this.nombre = nombre;
		this.dni = dni;
		this.desde = new Date();
		this.address = address;
	}

	//	Methods
	@Override
	public String toString() {
		return "User [address=" + address + ", desde=" + desde + ", dni=" + dni + ", email=" +
		email + ", nombre=" + nombre + "]";
	}

	//	Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
