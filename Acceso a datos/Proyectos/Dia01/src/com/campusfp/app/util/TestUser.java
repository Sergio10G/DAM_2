package com.campusfp.app.util;

import	com.campusfp.app.model.*;

public class TestUser {
	public static void main(String[] args) {
		Address a = new Address("Av de la industria", 70, "28946");
		User u = new User("a@b.c", "Antonio", "57392830A", a);

		System.out.println("Usuario:\t" + u.toString());
	}
}
