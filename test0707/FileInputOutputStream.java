package test0707;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputOutputStream {
	public static void main(String[] args) {
		boolean append = false;
		int i, len =0;
		String strFile01 = "C:/Program Files (x86)/Temp/EnumEx1.java";
		String strFile02= "C:/Program Files (x86)/Temp/Blank.java";
		
		InputStream in =null;
		OutputStream out =null;
		
		try {
			in = new FileInputStream(new File(strFile01)); //read
			out = new FileOutputStream(strFile02, append); //write
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		try {
			while((i=in.read()) != -1) {
				System.out.println(i);
				out.write(i);
				len++;
			}
			in.close();
			out.close();
			System.out.println(len+"bytes are copied...");
		}catch (IOException e) {
			System.out.println(e); 
		}
	}

}
