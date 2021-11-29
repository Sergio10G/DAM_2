package com.sdiezg.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		Generator gen = new Generator(numbers);
		Consumer con = new Consumer(numbers);
		gen.start();
		con.start();
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 9036cbce5ca762e7d81e9d1040481f666760ae67
