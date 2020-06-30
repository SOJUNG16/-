package test0630;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ExceptionTest2 {
	public static void main(String[] args) {
		ExceptionTest2 ex = new ExceptionTest2();
		ex.test2();
	}
	public void test1() {
		boolean append = false;
		int i, len =0;
		String strFile01 = "c:/Myproject/workspace/JavaStudy/HashSetLotto.java";
		String strFile02 = "c:/Myproject/workspace/JavaStudy/fileStreamTest.txt";
		
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(new File(strFile01));
			out = new FileOutputStream(strFile02,append); //try catch 안하면 컴파일 안됨
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void test2() {
		Cat2[] cats = new Cat2[10];
//		System.out.println(cats[11].name); 
//		System.out.println(cats[0].name);
		try {
			System.out.println(cats[11].name); //IndexOutofboundsException
			System.out.println(cats[0].name); //nullpointException
		} catch(IndexOutofboundsException)
		} catch(nullpointException)
	}
}
class Cat2{
	String name;
	int age;
	public Cat2(String name, int age) {
		this.name = name;
		this.age = age;
	}
}