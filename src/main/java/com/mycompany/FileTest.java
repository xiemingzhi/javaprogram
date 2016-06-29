package com.mycompany;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileTest {

	public static void main(String[] args) throws Exception {
		String filePath = "c:\\temp\test.txt";
		File file = new File(filePath);
		file.createNewFile();
		PrintWriter pw = new PrintWriter(new FileOutputStream(file));
		for (int i = 0; i < 10; i++) {
			pw.println(i);
		}
		pw.close();
	}

}
