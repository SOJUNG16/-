package test;
import java.util.Scanner;

class MyNameApp {
	public static void main(String[] args) {
		System.out.println("�̸�?");
		Scanner scanner = new Scanner(System.in);
		String name =  scanner.next();
		System.out.println("�� �̸��� "+name+" �Դϴ�");
		System.out.println("����?");
		int age = scanner.nextInt();
		System.out.println(""+age+"");
		System.out.println("Ű?");
		float height = scanner.nextFloat();
		System.out.println(""+height+"");
		
		
	}
}