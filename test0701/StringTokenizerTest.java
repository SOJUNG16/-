package test0701;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("This is a String");
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
		System.out.println("====================================");
		//인자로 주어진 문자열을 : 구분자로서 구분한다
		String str ="80::95:70";
		StringTokenizer st2 = new StringTokenizer(str,":",false);
		int i = 0;
		while(st2.hasMoreTokens()) {
			System.out.println(i+":"+st2.nextToken());
			i++;
		}
		System.out.println("====================================");
		//StringTokenizer는 구분자끼리 붙어 있는 경우 위와 같이 구분하지 못하는 문제
		String[] result = str.split(":");
		for(int x=0; x<result.length; x++) {
			System.out.println(x+":"+result[x]);
		}
		System.out.println("====================================");
		//split도 마지막에 구분자가 있을 땐 이를 처리하지 못함
		String str2 = "81-2-010-1234-5678";
		String[] arr2 = str2.split("-");
		for(int x=0; x<arr2.length; x++) {
			System.out.println(x+":"+arr2[x]);
		}
		System.out.println("====================================");
		String str3 = "81-2-010-1234-5678-";
		String[] arr3 = str3.split("-",6);
		for(int x=0; x<arr3.length; x++) {
			System.out.println(x+":"+arr3[x]);
		}
	}
}