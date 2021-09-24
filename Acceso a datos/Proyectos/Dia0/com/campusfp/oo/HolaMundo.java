package com.campusfp.oo;

public class HolaMundo {

	String s;
	MiGranClase mgc;

	public HolaMundo() {
		super();
		this.mgc = new MiGranClase();
		this.s = mgc.metodo();
	}
	public static void main(String[] args) {
		HolaMundo hm = new HolaMundo();
		CalculadoraCientifica calc = new CalculadoraCientifica();

		hm.p(calc.sumar(2, 2));
	}
	public void p(int r)
	{
		System.out.println("Resultado: " + r);
	}
}
