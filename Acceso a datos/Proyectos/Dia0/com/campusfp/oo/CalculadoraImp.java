package com.campusfp.oo;

public class CalculadoraImp implements iCalculadora {

	@Override
	public int sumar(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public int restar(int x, int y) {
		// TODO Auto-generated method stub
		return x - y;
	}

	@Override
	public int multiplicar(int x, int y) {
		// TODO Auto-generated method stub
		return x * y;
	}

	@Override
	public float dividir(int x, int y) {
		float div = 0;

		if (y != 0)
			div = (float) x / y;
		return div;
	}
	
}
