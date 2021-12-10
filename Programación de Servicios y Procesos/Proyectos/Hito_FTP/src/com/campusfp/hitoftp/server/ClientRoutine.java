package com.campusfp.hitoftp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.campusfp.hitoftp.resources.FileManager;
import com.campusfp.hitoftp.resources.Menu;

public class ClientRoutine extends Thread{
    // ATTRIBUTES
    private Socket socket;
    private FileManager fileManager;
	private boolean activo;
    
    // CONSTRUCTORS
    public ClientRoutine(Socket socket, FileManager fileManager) {
        this.socket = socket;
        this.fileManager = fileManager;
		this.activo = true;
    }
    
    // METHDOS
    @Override
    public void run() {
		String msgForClient = "main";
		boolean waiting = false;
		
		try {
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

			while (activo) {
				if (!waiting)
					outStream.writeUTF(msgForClient);
				waiting = false;
				msgForClient = "main";
			
				int clientPick = inStream.readInt();
				
				switch (clientPick) {
					/*
						Codigos de comunicación con el cliente:
						-1 - Terminar comunicación
						0 - Poner el servidor en estado "waiting"
						1 - Listar archivos del server
						2 - Activar el envio de archivos en el server
						3 - Activar la recepción de archivos en el server
					*/
					case 0:
						waiting = true;
						break;

					case 1:
						// Listar archivos del server
						msgForClient = Menu.optionListToText("download", fileManager.getFileNames());
						break;
					
					case 2:
						
						break;

					case 3:

						break;
				
					default:
						this.activo = false;
						break;
				}
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // GETTERS AND SETTERS
    
    
}
