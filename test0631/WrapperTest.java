package test0631;

public class WrapperTest {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer i2 = new Integer(100);
//		int i =100;
//		int i2 = 100;
		
		System.out.println("i==i2 ? "+(i==i2));
		System.out.println("i.equals(i2)?"+ i.equals(i2));
		System.out.println(i.compareTo(i2));
		System.out.println(i.toString());
	
	}
}
