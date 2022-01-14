package com.sdiezg.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadora extends Remote{
	public int suma(int n1, int n2) throws RemoteException;
	public int resta(int n1, int n2) throws RemoteException;
}
