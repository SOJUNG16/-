package test0701;

public class StringBufferTest {
	public static void main(String[] args) {
		
//		StringBuffer sb = new StringBuffer("abc");
//		sb.append("abc");
//		StringBuffer sb2 = sb.append("abc");
//		System.out.println(sb==sb2);				//true
		
//		StringBuffer sb = new StringBuffer("abc");
//		char c = sb.charAt(1);														
//		System.out.println(c);						//b
//		
//		StringBuffer sb = new StringBuffer("0123456");
//		StringBuffer sb2 = sb.delete(3, 6);
//		System.out.println(sb2);
		
		StringBuffer sb = new StringBuffer("0123456");
		StringBuffer c = sb.deleteCharAt(3);
		System.out.println(c);
	}


}
