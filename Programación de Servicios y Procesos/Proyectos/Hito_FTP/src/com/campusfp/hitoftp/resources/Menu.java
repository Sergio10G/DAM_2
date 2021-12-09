package com.campusfp.hitoftp.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    // METHDOS
    public static void printHeader() {
        System.out.println("o==============================o");
        System.out.println("o=            MENU            =o");
        System.out.println("o==============================o");
    }

    public static void printSeparator() {
        System.out.println("o==============================o");
    }
    
    public static void printEmptyLine() {
        System.out.println("o                              o");
    }

	private static String embedOption(int num, String option) {
		String out = "o  ";
		out += num + ". " + option;
		while (out.length() < 30) {
			out += " ";
		}
		out += " o";
		return out;
	}

	public static void printFromText(String text) {
		printFromList(textToList(text));
	}

	public static void printFromList(List<String> options) {
		printHeader();
		for (int i = 0; i < options.size(); i++) {
			System.out.println(embedOption(i + 1, options.get(i)));
		}
		printEmptyLine();
		System.out.println(embedOption(0, "Exit"));
		printSeparator();
	}

	public static String listToText(List<String> options) {
		String out = "";
		for (int i = 0; i < options.size(); i++) {
			out += options.get(i);
			if (i != options.size() - 1)
				out += ",";
		}
		return out;
	}

	public static List<String> textToList(String text) {
		return Arrays.asList(text.split(","));
	}

    
    // GETTERS AND SETTERS
    
    
}
