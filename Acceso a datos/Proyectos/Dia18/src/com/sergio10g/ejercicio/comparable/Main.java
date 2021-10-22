package com.sergio10g.ejercicio.comparable;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Persona p1= new Persona("juan","blanco",30);
    	Persona p2= new Persona("juan","alvarez",25);
    	Persona p3= new Persona("ana","sanchez",40);
    	Persona p4= new Persona("ana","simancas",30);
    	Persona p5= new Persona("ana","simancas",25);
    	Persona p6= new Persona("amaya","sierra",35);
    	Persona p7= new Persona("jose","perez",60);
    	List<Persona> lista= Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
		
        lista.stream().sorted().forEach(System.out::println);
	}
}
