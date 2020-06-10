package test;
import java.util.Scanner;

class MyNameApp {
	public static void main(String[] args) {
		System.out.println("이름?");
		Scanner scanner = new Scanner(System.in);
		String name =  scanner.next();
		System.out.println("제 이름은 "+name+" 입니다");
		System.out.println("나이?");
		int age = scanner.nextInt();
		System.out.println(""+age+"");
		System.out.println("키?");
		float height = scanner.nextFloat();
		System.out.println(""+height+"");
		
		
	}
}