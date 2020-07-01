package test0630;

public class StringTest {
	public static void main(String[] args) {
//		char[]c = {'C','E','L','L','O'};
//		String s = new String(c);
//		System.out.println(c); 			//문자 합치기
		
//		StringBuffer sb = new StringBuffer("Hello");
//		String s = new String(sb);
//		System.out.println(s);
		
//		String s ="Hello";
//		char c = s.charAt(4); 
//		System.out.println(c); 			//Hello의 4번째값
		
//		int I = "aaa".compareTo("aaa");
//		System.out.println(I);
		
//		String s = "Hello";
//		String s2 = s.concat("HHHH");
//		System.out.println(s2); 		//문자열 합치기
		
//		String s = "가나다라";
//		boolean b = s.contains("가나");
//		System.out.println(b);			//문자열에 가나가 있는지 true
		
//		String file = "Hello.cll";
//		boolean b = file.endsWith("cd");
//		System.out.println(b);			//지정된 문자열로 끝나는지
		
//		String s = "Helleo";
//		int idx1 = s.indexOf('o');
//		System.out.println(idx1);		// idx값 0부터 o있는 찾기
//		int idx2 = s.indexOf('e',0);
//		System.out.println(idx2);		//0부터 찾음
//		int idx3 = s.indexOf('e',2);
//		System.out.println(idx3);		// 2부터 찾음
		
//		String s = "ABCDEF";
//		int idx = s.indexOf("CD");
//		System.out.println(idx);
		
		String animals = "dog, cat, bear";
		String [] arr = animals.split(",");
		for(int i=0; i<arr.length; i++) {
		System.out.println("arr[i]="+arr[i]);
		}
		
	}
}
