package test0622;

public class Str {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = "abc";
		
		System.out.println("abc" == "abc");
		System.out.println(str1=="abc");
		System.out.println(str2 == "abc");
		System.out.println(str1 == str3);
		System.out.println(str1.equals("abc"));
		System.out.println(str2.equals("abc"));
		System.out.println(str2.equals("ABC"));
		System.out.println(str2.equalsIgnoreCase("ABC"));
		System.out.println(str1.equals(str3));
	}

}
