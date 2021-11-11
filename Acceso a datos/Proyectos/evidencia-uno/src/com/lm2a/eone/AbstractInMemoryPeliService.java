package com.lm2a.eone;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractInMemoryPeliService implements PeliService {

	List<Peli> pelis;


	@Override
	public List<Peli> populate() {
		pelis = new ArrayList<>();
		pelis.add(new Peli(1, "500 Days Of Summer", 2009, "tt1022603"));
		pelis.add(new Peli(2, "Beyond a Reasonable Doubt", 2009, "tt1183251"));
		pelis.add(new Peli(3, "Gamer", 2009, "tt1034032"));
		pelis.add(new Peli(4, "Cheri", 2009, "tt1179258"));
		pelis.add(new Peli(5, "Dorian Gray", 2009, "tt1235124"));
		pelis.add(new Peli(6, "Inglourious Basterds", 2009, "tt0361748"));
		pelis.add(new Peli(7, "Invictus", 2009, "tt1057500"));
		pelis.add(new Peli(8, "Julie and Julia", 2009, "tt1135503"));
		pelis.add(new Peli(9, "Los abrazos rotos", 2009, "tt0913425"));
		pelis.add(new Peli(10, "Of Mice and Men", 1992, "tt0105046"));
		pelis.add(new Peli(11, "Armored", 2009, "tt0913354"));
		pelis.add(new Peli(12, "Bornova Bornova", 2009, "tt1548542"));
		pelis.add(new Peli(13, "Coco avant Chanel", 2009, "tt1035736"));
		pelis.add(new Peli(14, "Nefes: Vatan sa?olsun", 2009, "tt1171701"));
		pelis.add(new Peli(15, "Up", 2009, "tt1049413"));
		pelis.add(new Peli(16, "Whiteout", 2009, "tt0365929"));
		pelis.add(new Peli(17, "The Time Travelers Wife", 2009, "tt0452694"));
		pelis.add(new Peli(18, "Whatever Works", 2009, "tt1178663"));
		pelis.add(new Peli(19, "Anonyma - Eine Frau in Berlin", 2009, "tt1035730"));
		pelis.add(new Peli(20, "Zombieland", 2009, "tt1156398"));
		pelis.add(new Peli(21, "Weather Girl", 2009, "tt1085515"));
		pelis.add(new Peli(22, "Watchmen", 2009, "tt0409459"));
		pelis.add(new Peli(23, "Adam Resurrected", 2008, "tt0479341"));
		pelis.add(new Peli(24, "Angels and Deamons", 2009, "tt0808151"));
		pelis.add(new Peli(25, "Away We Go", 2009, "tt1176740"));
		pelis.add(new Peli(26, "Last Ride", 2009, "tt1235142"));
		pelis.add(new Peli(27, "The Boys Are Back", 2009, "tt0926380"));
		pelis.add(new Peli(28, "Nothing But the Truth", 2008, "tt1073241"));
		pelis.add(new Peli(29, "100 Feet", 2008, "tt0899128"));
		pelis.add(new Peli(30, "The Tournament", 2009, "tt0471041"));
		pelis.add(new Peli(31, "Nordwand", 2008, "tt0844457"));
		pelis.add(new Peli(32, "A Serious Man", 2009, "tt1019452"));
		pelis.add(new Peli(33, "Saw VI", 2009, "tt1233227"));
		pelis.add(new Peli(34, "Ne te retourne pas", 2009, "tt1075113"));
		pelis.add(new Peli(35, "District 9", 2009, "tt1136608"));
		pelis.add(new Peli(36, "Extract", 2009, "tt1225822"));
		pelis.add(new Peli(37, "Five Minutes of Haven", 2009, "tt1238291"));
		pelis.add(new Peli(38, "High Life", 2009, "tt1143110"));
		pelis.add(new Peli(39, "The Proposal", 2009, "tt1041829"));
		pelis.add(new Peli(40, "Veronika Decides to Die", 2009, "tt1068678"));
		pelis.add(new Peli(41, "The Other Man", 2008, "tt0974613"));
		pelis.add(new Peli(42, "The Goods: Live Hard, Sell Hard", 2009, "tt1092633"));
		pelis.add(new Peli(43, "The Hangover", 2009, "tt1119646"));
		pelis.add(new Peli(44, "Public Enemies", 2009, "tt1152836"));
		pelis.add(new Peli(45, "Creation", 2009, "tt0974014"));
		pelis.add(new Peli(46, "Amelia", 2009, "tt1129445"));
		pelis.add(new Peli(47, "The Rebound", 2009, "tt1205535"));
		pelis.add(new Peli(48, "Powder Blue", 2009, "tt1032819"));
		pelis.add(new Peli(49, "The Men Who Stare at Goats", 2009, "tt1234548"));
		pelis.add(new Peli(50, "Bright Star", 2009, "tt0810784"));
		return pelis;
	}


	@Override
	public Peli peliculaCuyoIMDBSeaEste(String imdb) {
		if (pelis == null)
			populate();
		List<Peli> matches = pelis.stream().filter(peli -> peli.getImdb().equals(imdb)).collect(Collectors.toList());
		return matches.size() > 0 ? matches.get(0) : null;
	}


	@Override
	public List<Peli> peliculasConAnioMenorA2009() {
		if (pelis == null)
			populate();
		return pelis.stream().filter(peli -> peli.getAnio() < 2009).collect(Collectors.toList());
	}


	@Override
	public List<Peli> peliculasQueEmpiezanConA() {
		if (pelis == null)
			populate();
		return pelis.stream().filter(peli -> peli.getTitulo().toUpperCase().startsWith("A")).collect(Collectors.toList());
	}
	
	
	
	

}
