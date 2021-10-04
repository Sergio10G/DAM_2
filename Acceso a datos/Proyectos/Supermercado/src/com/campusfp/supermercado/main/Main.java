package com.campusfp.supermercado.main;

import java.util.ArrayList;
import java.util.Date;
import com.campusfp.supermercado.model.*;

public class Main {
	public static void main(String[] args) {
		ProdCongelado pc = new ProdCongelado(new Date(), "33333333333333333", "Croquetas", new Date(), "España", 2.53f);
		ProdCongelado pc1 = new ProdCongelado(new Date(), "22222222222222222", "Sardinas", new Date(), "España", 13.27f);
		ProdCongelado pc2 = new ProdCongelado(new Date(), "111111111111111111", "Angulas", new Date(), "España", 12.05f);
		ProdCongelado pc3 = new ProdCongelado(new Date(), "4444444444444444", "Espinacas", new Date(), "España", 8.95f);

		ArrayList<ProdFrio> all = new ArrayList<ProdFrio>();
		ArrayList<ProdFrio> selected = new ArrayList<ProdFrio>();

		all.add(pc);
		all.add(pc1);
		all.add(pc2);
		all.add(pc3);

		selected = provieneDeOrdenado(all, "España");

		System.out.println("Provenientes de España:");
		for (ProdFrio pr : selected)
			System.out.println(pr);
	}

	public static ArrayList<ProdFrio> provieneDe(ArrayList<ProdFrio> prs, String pais) {
		ArrayList<ProdFrio> select = new ArrayList<ProdFrio>();
		
		for (ProdFrio pf : prs) {
			if (pf.getPais_origen().equals(pais))
				select.add(pf);
		}
		return select;
	}

	public static ArrayList<ProdFrio> provieneDeOrdenado(ArrayList<ProdFrio> prs, String pais) {
		NombreComparator pc = new NombreComparator();
		ArrayList<ProdFrio> select = new ArrayList<ProdFrio>(1);

		for (ProdFrio pf : prs) {
			if (pf.getPais_origen().equals(pais))
				select.add(pf);
		}
		select.sort(pc);
		return select;
	}

}
