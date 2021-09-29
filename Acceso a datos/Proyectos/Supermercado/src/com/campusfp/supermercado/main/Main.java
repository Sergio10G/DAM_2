package com.campusfp.supermercado.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import com.campusfp.supermercado.model.ProdCongelado;
import com.campusfp.supermercado.model.ProdFrio;

public class Main {
	public static void main(String[] args) {
		ProdCongelado pc = new ProdCongelado(new Date(), "111111111111111111", new Date(), 12.05, "España");
		ProdCongelado pc1 = new ProdCongelado(new Date(), "22222222222222222", new Date(), 13.05, "Noruega");
		ProdCongelado pc2 = new ProdCongelado(new Date(), "33333333333333333", new Date(), 21.05, "España");
		ProdCongelado pc3 = new ProdCongelado(new Date(), "4444444444444444", new Date(), 2.05, "Irlanda");

		ArrayList<ProdFrio> all = new ArrayList<ProdFrio>();
		ArrayList<ProdFrio> selected = new ArrayList<ProdFrio>();

		all.add(pc);
		all.add(pc1);
		all.add(pc2);
		all.add(pc3);

		selected = provieneDe(all, "España");

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
		ArrayList<ProdFrio> select = new ArrayList<ProdFrio>();
		for (ProdFrio pf : prs) {
			if (pf.getPais_origen().equals(pais))
				select.add(pf);
		}
		return select.sort();	//	TODO
	}

}
