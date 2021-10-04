package com.campusfp.supermercado.main;

import java.util.Comparator;
import com.campusfp.supermercado.model.ProdFrio;

public class NombreComparator implements Comparator<ProdFrio> {

	private int num;

	public NombreComparator() {
		this.num = 0;
	}

	public NombreComparator(int num) {
		this.num = num;
	}

	@Override
	public int compare(ProdFrio p1, ProdFrio p2) {
		if (num == 0)
			return p1.getNombre().compareTo(p2.getNombre());
		return p1.getPais_origen().compareTo(p2.getPais_origen());
	}
	
}
