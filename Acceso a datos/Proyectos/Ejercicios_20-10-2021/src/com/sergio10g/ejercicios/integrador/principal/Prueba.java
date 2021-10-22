package com.sergio10g.ejercicios.integrador.principal;

import java.util.ArrayList;
import java.util.List;

public class Prueba {
	public static void main(String[] args) {
		List<Integer> ls = new ArrayList<>();

		ls.add(1);
		for (Integer integer : ls) {
			System.out.println(integer);
			ls.add(integer + 1);	// Esto explota
		}
	}
}
