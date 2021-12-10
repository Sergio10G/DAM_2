package com.campusfp.hitoftp.resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    // ATTRIBUTES
    private File rootDir; 
    private List<File> files;
    
    // CONSTRUCTORS
    public FileManager(String rootPath) {
        this.rootDir = new File(rootPath);
        scan();
    }

    // METHDOS
    public void scan() {
        files = Arrays.asList(rootDir.listFiles());
    }

	/*
    public byte[] fileToBytes(String fileName) throws IOException { 
        File file = getFileByName(fileName);

        return Files.readAllBytes(file.toPath());
    }

    public File fileFromBytes(String path, byte[] fileContent) throws IOException {
        File file = new File(path);
        Files.write(file.toPath(), fileContent, StandardOpenOption.WRITE);
        scan();
        return file;
    }
	*/

	public boolean createFile(String fileName, List<byte[]> fileContent) {
		File newFile = new File(rootDir.getAbsolutePath() + "\\" + fileName);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
			for (byte[] bs : fileContent) {
				bw.append(bs.toString());
			}
			bw.flush();
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
    
    // GETTERS AND SETTERS
    public List<File> getFiles() {
		scan();
        return this.files;
    }

	public List<String> getFileNames() {
		scan();
        return Arrays.asList(this.rootDir.list());
    }

    public File getFileByName(String fileName) {
		scan();
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }
    
}