package com.sergio10g.ejercicios.primeros;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio8 {
	//	Attributes
	
	
	//	Constructors
	
	
	//	Methods
	public List<String> listaMayus(List<String> ls) {
		return ls.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
	}
	
	//	Getters & Setters
	
	
}
