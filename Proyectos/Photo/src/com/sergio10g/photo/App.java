package com.sergio10g.photo;
public class App {
    public static void main(String[] args) throws Exception {
		int sides = 4;
        while (true) {
			int a = (int) (Math.random() * sides + 1);
			System.out.println(a);
			if (a == sides)
				break;
		}
    }
}
