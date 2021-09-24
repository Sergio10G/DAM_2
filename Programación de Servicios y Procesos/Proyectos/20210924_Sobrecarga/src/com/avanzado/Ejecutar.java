package com.avanzado;

import com.avanzado.model.Cliente;
import com.basico.Hijo;

public class Ejecutar {
	public static void main(String[] args) {
		Hijo hijo = new Hijo();
		Cliente cliente = new Cliente();
		
		cliente.setNombre("Juan");
		System.out.println(cliente.getNombre());
	}
}
