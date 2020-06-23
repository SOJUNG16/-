package test0623;

class Employee {
		Employee() {
			System.out.println("나는 부모 constructor");
		
		 //Employee(int a) {
		 //System.out.println("나는 부모 constructor");
		 
		}
}
class Manager extends Employee {
	Manager() {
		//super(1);
		//super(); 
		System.out.println("나는 자식 constructor ");
	}
}

public class TestSuper {
	public static void main(String[] args) {
		Manager m = new Manager();
	}
}
