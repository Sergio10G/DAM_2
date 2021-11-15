package com.sdiezg.pruebaSingleton;

public class Singleton {
	//	Attributes
	public static Singleton self = new Singleton();
	
	//	Constructors
	private Singleton() {
		
	}
	
	//	Methods
	
	
	//	Getters & Setters
	public static Singleton getSelf() {
		return self;
	}

	public static void setSelf(Singleton self) {
		Singleton.self = self;
	}
	
}
