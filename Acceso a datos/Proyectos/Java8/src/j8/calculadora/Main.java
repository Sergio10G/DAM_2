package j8.calculadora;

public class Main {
	public static void main(String[] args) {
		float val1 = 35;
		float val2 = 0;
		ICalculadora suma = 			(v1, v2) -> v1 + v2;
		ICalculadora resta = 			(v1, v2) -> v1 - v2;
		ICalculadora multiplicacion =	(v1, v2) -> v1 * v2;
		ICalculadora division = 		(v1, v2) -> v2 != 0 ? v1 / v2 : Float.POSITIVE_INFINITY;

		System.out.println(val1 + " + " + val2 + " = " + suma.calcular(val1, val2));
		System.out.println(val1 + " - " + val2 + " = " + resta.calcular(val1, val2));
		System.out.println(val1 + " * " + val2 + " = " + multiplicacion.calcular(val1, val2));
		System.out.println(val1 + " / " + val2 + " = " + division.calcular(val1, val2));
	}
}
