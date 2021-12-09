package com.campusfp.hitoftp.experimental;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class ReadFiles {
    static List<String> fileNames;
    static List<File> files;
    public static void main(String[] args) {
        String rootPath = "./serverfiles";

        File rootDir = new File(rootPath);
        files = Arrays.asList(rootDir.listFiles());
        fileNames = Arrays.asList(rootDir.list());

        for (File file : files) {
            PrintWriter pw;
            try {
                pw = new PrintWriter(file);
                pw.write(file.getAbsolutePath());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
