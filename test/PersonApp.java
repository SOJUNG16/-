package test;
import java.util.Scanner;

class PersonApp{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person[] persons = new Person[3];
		for(int i=1; i<3; i++) {
			Person person = new Person();
			System.out.println("이름은 뭡니까?");
			Person.name = scanner.next();
			System.out.println("나이는?");
			
		}
	}
}