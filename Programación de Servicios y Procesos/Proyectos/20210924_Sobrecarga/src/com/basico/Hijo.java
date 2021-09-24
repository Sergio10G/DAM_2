package com.basico;

public class Hijo extends Padre implements ITareas{
	//	Attributes

	//	Sobreescritura, Overriding
	@Override
	protected void escribir() {
		System.out.println("Escribiendo Hijo");
	}

	//	Sobrecarga, Overloading
	protected void escribir(String mensaje) {
		System.out.println("Escribiendo " + mensaje);
	}

	@Override
	public void examen1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void examen2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hito1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hito2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hitoGrupal() {
		// TODO Auto-generated method stub
		
	}

	/*	MAL!!
	protected String escribir(String mensaje) {
		return ("Escribiendo " + mensaje);
	}
	*/

	//	Constructors


	//	Methods


	//	Getters & Setters


}
