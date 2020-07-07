package test0707;

public class GenericTest2 {
	public static void main(String[] args) {
		Parent<String,Integer>p = new Parent<String,Integer>("홍길동",30);
		System.out.println(p);
		Parent.<String>callChild2("test"); //제네릭 메소드 사용방법
	}

}
class Parent<T1,T2> {
	private T1 name;
	private T2 age;
	
	public Parent(T1 name, T2 age) {
		this.name = name;
		this.age = age;
	}
	public T1 getName() {
		return name;
	}

	public void setName(T1 name) {
		this.name = name;
	}

	public T2 getAge() {
		return age;
	}

	public void setAge(T2 age) {
		this.age = age;
	}
	//static에서는 generic사용못함
	/*
	 * public static void callChild(T1 a) {
	 * System.out.println(a);}
	 */
	
	//제네릭메서드: 메서드 내에서 사용하는 Generic
	//메서드 종료되면 자동으로 사라짐
	public static<T> void callChild2(T a) {
	System.out.println(a);
	}
	@Override
	public String toString() {
	return "name=" + name + ", age=" + age + "";
	}

}