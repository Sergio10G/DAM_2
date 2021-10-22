package com.sergio10g.ejercicio.vehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
 
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("3333CCC", Modelo.OPEL, 30000));
        vehiculos.add(new Vehiculo("1111AAA", Modelo.BMW, 10000));
        vehiculos.add(new Vehiculo("5555EEE", Modelo.AUDI, 200000));
        vehiculos.add(new Vehiculo("4444DDD", Modelo.BMW, 100000));
        vehiculos.add(new Vehiculo("2222BBB", Modelo.AUDI, 20000));
        vehiculos.add(new Vehiculo("6666FFF", Modelo.OPEL, 300000));
        vehiculos.add(new Vehiculo("7777GGG", Modelo.CITROEN, 0));

		Main m = new Main();

		System.out.println("Ordenados por kilómetros:");
		m.print(vehiculos.stream().sorted().collect(Collectors.toList()));

		System.out.println("\nListado de modelos:");
		vehiculos.stream().map(v -> v.getModelo()).distinct().forEach(mod -> System.out.println(mod));

		System.out.println("\nListado de modelos limitado a 3 marcas:");
		vehiculos.stream().map(v -> v.getModelo()).distinct().limit(3).forEach(mod -> System.out.println(mod));

		System.out.println("\nListado de modelos Saltándose la primera:");
		vehiculos.stream().map(v -> v.getModelo()).distinct().skip(1).forEach(mod -> System.out.println(mod));

		System.out.println("\n-> Ejercicio 1:");
		m.listarKilometraje(vehiculos);

		System.out.println("\n-> Ejercicio 2:");
		m.print(m.multiplicarKilometraje(vehiculos));

		System.out.println("\n-> Ejercicio 3:");
		m.print(m.filtrarAudi(vehiculos));

    }

	public void print(List<Vehiculo> vehiculos) {
		vehiculos.stream().forEach(v -> System.out.println(v));
	}
 
	public void listarKilometraje(List<Vehiculo> vehiculos) {
		vehiculos.stream().forEach(v -> System.out.println(v.getMatricula() + ": " + v.getKilometros()));
	}

	public List<Vehiculo> multiplicarKilometraje(List<Vehiculo> vehiculos) {
		return vehiculos.stream()
						.map(v -> {
							v.setKilometros(v.getKilometros() * 2);
							return v;
						})
						.collect(Collectors.toList());
	}

	public List<Vehiculo> filtrarAudi(List<Vehiculo> vehiculos) {
		return vehiculos.stream().filter(v -> v.getModelo() == Modelo.AUDI).collect(Collectors.toList());
	}

}
