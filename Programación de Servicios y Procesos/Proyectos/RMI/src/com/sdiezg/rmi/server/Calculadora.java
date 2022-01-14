package com.sdiezg.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora extends UnicastRemoteObject implements ICalculadora {
	// Attributes
	private static final long serialVersionUID = 2492476430269444752L;

	// Constructors
	protected Calculadora() throws RemoteException {
		super();

	}

	// Methods
	@Override
	public int suma(int n1, int n2) throws RemoteException {
		return n1 + n2;
	}

	@Override
	public int resta(int n1, int n2) throws RemoteException {
		return n1 - n2;
	}

	// Getters & Setters

}
