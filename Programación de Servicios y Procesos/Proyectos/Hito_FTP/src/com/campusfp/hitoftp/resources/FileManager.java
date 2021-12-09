package com.campusfp.hitoftp.resources;

import java.io.File;
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
    
    // GETTERS AND SETTERS
    public List<File> getFiles() {
		this.scan();
        return this.files;
    }

	public List<String> getFileNames() {
		this.scan();
        return Arrays.asList(this.rootDir.list());
    }

    public File getFileByName(String fileName) {
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }
    
}