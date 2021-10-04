package com.campusfp.FastFood.Main;

import com.campusfp.FastFood.model.Empleado;
import com.campusfp.FastFood.model.Restaurante;

public class Main {
	public static void main(String[] args) {
		Empleado e1 = new Empleado("Joan", Restaurante.MCDONADLS);
		Empleado e2 = new Empleado("Marta", Restaurante.BURGER_KING);
		Empleado e3 = new Empleado("Luis", Restaurante.KFC);
		Empleado e4 = new Empleado("Monica", Restaurante.VIPS);
	}
}
