package test0630;

public class InterfaceTest6 {
	public static void main(String[] args) {
		Race[] rs = new Race[2];
		rs[0] = new Korean2("홍길동",28);
		rs[1] = new American2("Tom",29);
		
		for(Race r : rs) {
			System.out.println(r.getRace());
		}
	}

}
interface Race{
	public abstract String getRace();
}

class Korean2 implements Race {
	String name;
	int age;
	
	public Korean2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void work() {
		System.out.println("걷는다");
	}
	public void talk() {
		System.out.println("한국말한다");
	}
	public String getRace() {
		return "황인종";
	}
}

class American2 implements Race {
	String name;
	int age;
	
	public American2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void work() {
		System.out.println("걷는다");
	}
	public void talk() {
		System.out.println("미국말한다");
	}
	public String getRace() {
		return "백인종";
	}
}