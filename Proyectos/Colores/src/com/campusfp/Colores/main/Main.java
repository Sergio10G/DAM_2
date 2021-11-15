package com.campusfp.Colores.main;

import com.campusfp.Colores.clases.Colors;

public class Main {
	public static void main(String[] args) {
		/*
		Colors.printString(Colors.EColors.WHITE_BACKGROUND, "ASDJALSJDLk");
		*/
		for (Colors.EColors c : Colors.getColors()) {
			Colors.printString(c, "Aa");
			System.out.print("  ");
		}
		/*
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 104; j++) {
				Colors.printChar(Colors.randomColor(), (char) (((i + j) % 3) + '░'));
			}
			System.out.println();
		}
		*/
	}
}
