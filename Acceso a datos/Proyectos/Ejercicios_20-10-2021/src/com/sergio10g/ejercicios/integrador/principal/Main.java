package com.sergio10g.ejercicios.integrador.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sergio10g.ejercicios.integrador.clases.Empleado;
import com.sergio10g.ejercicios.integrador.clases.Jornales;
import com.sergio10g.ejercicios.integrador.clases.Liquidacion;

public class Main {
	public static void main(String[] args) {
		List<Empleado> empleados = new ArrayList<>();
		List<Jornales> lsJornales;
		List<Liquidacion> lsLiq;

		// Generamos la lista de empleados, completamente aleatoria.
		for (int i = 0; i < 25; i++) {
			lsJornales = new ArrayList<Jornales>();
			for (int j = 0; j < (int) numAleatorioRango(1, 3); j++) {
				lsJornales.add(new Jornales(numAleatorioRango(4, 12), numAleatorioRango(10, 30)));
			}
			String nombre = nombreAlAzar(Nombre.getLista());
			empleados.add(new Empleado(nombre, nombre + "@gmail.com", (int) numAleatorioRango(1, 10), lsJornales));
		}

		// Generamos la lista de liquidaciones a partir de la de empleados
		lsLiq = procesarLista(empleados);
		// Procesamos la lista para que aparezca en orden decreciente
		Collections.sort(lsLiq, (l1, l2) -> (l1.getMonto() > l2.getMonto()) ? 1 : -1);
		Collections.reverse(lsLiq);

		System.out.println("Tercer empleado en orden de liquidación: " + lsLiq.get(2).getEmpleado().getNombre() + " => " + lsLiq.get(2).getMonto() + "€");

		// Ordenar los empleados alfabéticamente
		System.out.println("Empleados ordenados alfabéticamente:");
		empleados = ordenarAlfabeticamente(empleados);
		for (Empleado empleado : empleados) {
			System.out.println(empleado.getNombre());
		}

		// Ordenar los empleados por categoría
		System.out.println("Empleados ordenados por categoría:");
		empleados = ordenarPorCategoria(empleados);
		for (Empleado empleado : empleados) {
			System.out.println(empleado.getNombre() + " -> " + empleado.getCategoria());
		}
	}

	// Metdos de los ejercicios 4.1 y 4.2
	public static String nombreAlAzar(String[] arr) {
		return arr[(int) (Math.random() * arr.length)];
	}

	public static float numAleatorioRango(int start, int end) {
		return (float) (Math.random() * (end - start + 1) + start);
	}

	//	Metodo que procesa la lista de empleados y devuelve la lista de liquidaciones
	public static List<Liquidacion> procesarLista(List<Empleado> lista) {
		List<Liquidacion> listLiq = new ArrayList<>();
		float monto;
		for (Empleado emp : lista) {
			monto = 0;
			for (Jornales j : emp.getLsJornales()) {
				monto += j.getDiasTrab() * j.getHorasTrab() * 15.5f;
			}
			monto *= (1 + emp.getCategoria() / 100);
			listLiq.add(new Liquidacion(emp, monto));
		}
		return listLiq;
	}

	// Metodos de ordenación
	public static List<Empleado> ordenarAlfabeticamente(List<Empleado> lista) {
		Collections.sort(lista, (e1, e2) -> e1.getNombre().compareTo(e2.getNombre()) > 0 ? 1 : -1);
		return lista;
	}

	public static List<Empleado> ordenarPorCategoria(List<Empleado> lista) {
		Collections.sort(lista, (e1, e2) -> e1.getCategoria() > e2.getCategoria()? 1 : -1);
		return lista;
	}
}
