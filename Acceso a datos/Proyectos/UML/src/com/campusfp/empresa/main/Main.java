package com.campusfp.empresa.main;

import java.util.ArrayList;
import java.util.List;

import com.campusfp.empresa.model.Directivo;
import com.campusfp.empresa.model.Empleado;
import com.campusfp.empresa.model.Oficial;
import com.campusfp.empresa.model.Operario;
import com.campusfp.empresa.model.Tecnico;

public class Main {
	public static void main(String[] args) {
		Empleado emp1 = new Empleado("Jose");
		Empleado emp2 = new Empleado("Antonio");
		Tecnico tec1 = new Tecnico("María", "123abc");
		Tecnico tec2 = new Tecnico("Javioer", "234xyz");
		Directivo dir1 = new Directivo("Luis", "Madrid");
		Directivo dir2 = new Directivo("Ana", "La Rioja");
		Oficial ofi1 = new Oficial("Jose Antonio", "2389asd", "Capataz");
		Oficial ofi2 = new Oficial("Bruno", "j2rjhk12", "Supervisor");
		Operario ope1 = new Operario("Jose Luis", "kdi1212125", "Grua");
		Operario ope2 = new Operario("Antonio José", "12UE1L2J" ,"Martillo neumático");
	
		List<Empleado> ls = new ArrayList<Empleado>();

		ls.add(emp1);
		ls.add(emp2);
		ls.add(tec1);
		ls.add(tec2);
		ls.add(dir1);
		ls.add(dir2);
		ls.add(ofi1);
		ls.add(ofi2);
		ls.add(ope1);
		ls.add(ope2);

		for (Empleado e : ls)
		{
			System.out.print(e);
			System.out.println("\tSalario=" + e.calcularSalario((int) (Math.random() * 200) + 1, (float) (Math.random() * 50)) + "€");
		}
	}
}
