package com.campusfp.hitoftp.resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
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

	public boolean createFile(String fileName, List<String> fileContent) {
        try {
            File newFile = new File(rootDir.getAbsolutePath() + "\\" + fileName);
			if (Files.exists(newFile.toPath())) {
				Files.delete(newFile.toPath());
			};
			Files.createFile(newFile.toPath());
			BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

			for (String str : fileContent) {
				bw.write(str);
			}

			bw.close();
            return true;
        } catch (Exception e) {
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