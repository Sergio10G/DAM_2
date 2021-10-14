package j8.practica;

import java.util.function.Predicate;

public class Main2 {
	public static void main(String[] args) {
		String s = "Hola";
		StringAnalysis sa = (str) -> str.length() > 5;

		System.out.println("Metodo propio: " + esMayorQueCinco(masQueCincoMetodo(s)) + 
		"\nMétodo interfaz: " + esMayorQueCinco(sa.masQueCinco(s)));

		Predicate<String> longitud = p -> p.length() > 5;
		System.out.println(esMayorQueCinco(longitud.test(s)));
	}

	public static boolean masQueCincoMetodo(String str) {
		return str.length() > 5;
	}

	public static String esMayorQueCinco(boolean b) {
		if (b)
			return "Es mayor que 5";
		return "Es menor que 5";
	}
}
