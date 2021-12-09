package com.campusfp.hitoftp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.campusfp.hitoftp.resources.FileManager;
import com.campusfp.hitoftp.resources.Menu;

public class ClientRoutine extends Thread{
    // ATTRIBUTES
    private Socket socket;
    private FileManager fileManager;
    
    // CONSTRUCTORS
    public ClientRoutine(Socket socket, FileManager fileManager) {
        this.socket = socket;
        this.fileManager = fileManager;
    }
    
    // METHDOS
    @Override
    public void run() {
		final List<String> mainMenu = Arrays.asList("Listar ficheros", "Descargar fichero", "Subir fichero");
		List<String> downloadableFiles = new ArrayList<>();
		List<String> uploadableFiles = new ArrayList<>();
		Map<String, List<String>> menus = new HashMap<>();
		menus.put("main", mainMenu);
		menus.put("download", downloadableFiles);
		menus.put("upload", uploadableFiles);
		String currentLevel = "main";
		
		try {
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

			if (!currentLevel.equals("waiting"))
				outStream.writeUTF(Menu.listToText(menus.get(currentLevel)));

			int userPick = inStream.readInt();
			switch (currentLevel) {
				case "main":
						if(userPick == 2) {
							downloadableFiles = fileManager.getFileNames();
							currentLevel = "download";
						}
						else if (userPick == 3) {
							currentLevel = "waiting";
						}
					break;
				
				case "download":

					break;
				
				case "upload":

					break;
				
				case "waiting":
					currentLevel = "main";
					break;
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // GETTERS AND SETTERS
    
    
}
