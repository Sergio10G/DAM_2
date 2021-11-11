package com.lm2a.eone;

import java.util.List;

public interface PeliService {

	List<Peli> populate();
	
	List<Peli> peliculasQueEmpiezanConA();
	
	List<Peli> peliculasConAnioMenorA2009();
	
	Peli peliculaCuyoIMDBSeaEste(String imdb);

}