package test0625;

public class StaticTest {
	public static void main(String[] args) {
		Customer c = new Customer(100, "홍길동");
		Customer c2 = new Customer(101, "김길동");
		
		EnterAdam.entrance(c);
		EnterAdam.entrance(c2);
		
		System.out.println(EnterAdam.getCount());
	}

}

class EnterAdam {
	static int count;
	static final int maxCnt = 100;
	static Customer [] custs = new Customer[maxCnt]; //static인것만 사용가능
	
	public static void entrance(Customer c) { 
		if(c != null) custs [count++] = c;
	}
	public static int getCount() { 
		return count;
	}
	
}
class Customer {
	int number;
	String name;
	
	public Customer(int number, String name) {
		this.number = number;
		this.name = name;
	}
}