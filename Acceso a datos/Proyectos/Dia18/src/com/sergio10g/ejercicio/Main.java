package com.sergio10g.ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		/*
		List<Alumno> alumnos = new ArrayList<>();
		alumnos.add(new Alumno("Antonio", 20));
		alumnos.add(new Alumno("Alicia", 19));
		alumnos.add(new Alumno("Laura", 17));
		alumnos.add(new Alumno("Ricardo", 16));
		alumnos.add(new Alumno("Isidoro", 22));

		System.out.println("Alumnos mayores de edad:");
		m.filtro(alumnos);
		*/
		EjerciciosApi ea = new EjerciciosApi();

		List<String> lista = new ArrayList<>();
		lista.add("Permita que me arrepienta oh");
		lista.add("mi bella cenicienta,");
		lista.add("de rodillas mi presencia");
		lista.add("si mi ausencia fue tu afrenta.");
		lista.add("Que noches, que noches tan bonitas,");
		lista.add("Siloé en sus callesitas,");
		lista.add("al fondo mi valle en risa");
		lista.add("¡ay! todito se divisa.");
		lista.add("Un clásico en el Pascual,");
		lista.add("adornado de mujeres sin par,");
		lista.add("América y Cali a ganar,");
		lista.add("aquí no se puede empatar.");
		lista.add("Barranquilla, puerta de oro");
		lista.add("Paris la ciudad luz");
		lista.add("Nueva York capital del mundo");
		lista.add("y del cielo Cali, la sucursal");
		lista.add("A millas siento tu aroma,");
		lista.add("cualquiera justo razona,");
		lista.add("que Cali es Cali señoras, señores");
		lista.add("lo demás es loma.");
		lista.add("FIN");


		System.out.println("-> Ejercicio 1:");
		m.print(ea.ejercicio1(lista));
		System.out.println("\n");
		System.out.println("-> Ejercicio 2:");
		m.print(ea.ejercicio2(lista));
		System.out.println("\n");
		System.out.println("-> Ejercicio 3:");
		System.out.println(ea.ejercicio3(lista));
	}

	public void print(List<String> lista) {
		lista.forEach(p -> System.out.println(p));
	}

	public void filtro(List<Alumno> alumnos){
		List<Alumno> listadoAlumnos = filtrarAlumnoEdad(alumnos);
		listadoAlumnos.forEach(c -> System.out.println(c.getNombre()));
	}

	public List<Alumno> filtrarAlumnoEdad(List<Alumno> alumnos){
		return alumnos.stream()
						.filter(c -> c.getEdad() > 18)
						.collect(Collectors.toList());
	}
}
