package com.campusfp.veterinaria.main;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import com.campusfp.veterinaria.model.Perro;

public class Main {
	public static void main(String[] args) {
		/*
		List<Perro> lista = new ArrayList<Perro>();
		Perro p1 = new Perro("Juan");
		Perro p2 = new Perro("Bobby");
		Perro p3 = new Perro("Max");
		int	c = 0;
		*/

		Set<Perro> lista = new HashSet<Perro>();
		Perro p1 = new Perro("Juan");
		Perro p2 = new Perro("Bobby");
		Perro p3 = new Perro("Max");
		int	c = 0;

		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p3);
		for (Perro p : lista)
		{
			System.out.println("Perro " + (++c) + ": " + p.getNombre());
		}
	}
}
