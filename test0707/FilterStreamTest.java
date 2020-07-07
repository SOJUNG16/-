package test0707;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilterStreamTest {
	public static void main(String[] args) {
		int c = 0;
		try {
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("C:/Program Files (x86)/Temp/Blak.java")))
			
			while((c = in.read()) >=0) {
				System.out.println((char)c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class LowerCaseInputStream extends FilterInputStream {
		protected LowerCaseInputStream(InputStream in){
			super(in);
		}
		public int read() throws IOException{
			int c = super.read();
			return (c== -1 ? c: Character.toLowerCase((char)c));
		}
		public int read(byte[] b, int offset, int len) throws IOException{
			int result = super.read(b,offset,len);
		for(int i = offset; i<offset+result; i++) {
			b[i] = (byte)Character.toLowerCase((char)b[i]);
		}
		return result;
	}

	}
}
