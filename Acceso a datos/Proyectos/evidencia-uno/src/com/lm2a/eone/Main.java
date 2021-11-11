package com.lm2a.eone;

import java.util.List;

public class Main extends AbstractInMemoryPeliService {
	
	public Main() {
		super.populate();
	}

	public static void main(String[] args) {
		Main m = new Main();
		String imdb = "tt1092633";

		Peli peliImdb = m.peliculaCuyoIMDBSeaEste(imdb);
		List<Peli> pelisMenor2009 = m.peliculasConAnioMenorA2009();
		List<Peli> pelisEmpiezanPorA = m.peliculasQueEmpiezanConA();

		System.out.println("Película con el imdb " + imdb + ":");
		System.out.println(peliImdb);
		System.out.println("-----------------------------------------------------");
		System.out.println("Películas con año menor a 2009:");
		for (Peli peli : pelisMenor2009)
			System.out.println(peli);
		System.out.println("-----------------------------------------------------");
		System.out.println("Películas que empiezan por \"A\":");
		for (Peli peli : pelisEmpiezanPorA)
			System.out.println(peli);
	}
}
