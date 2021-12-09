package com.campusfp.hitoftp.experimental;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.campusfp.hitoftp.resources.Menu;

public class ReadFiles {
    static List<String> fileNames;
    static List<File> files;
    public static void main(String[] args) {
        List<String> options = new ArrayList<>();

		options.add("opcion 1");
		options.add("opcion 2");
		options.add("opcion 3");
		Menu.printFromList(options);
    }
}
