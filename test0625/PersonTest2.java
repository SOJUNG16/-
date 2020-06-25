package test0625;

import java.util.Arrays;

class Person2 {
	String name;
	int age;
	private final int hobbySize = 10; //멤버변수가 참조형 주소가 변경되지 않고 값만 변경
	String [] hobbys = new String[hobbySize]; //자체적으로 방을 하나 할당받음 그 방에 컵 10개
	Person2() {
	}
	Person2(Person2 p) {
		this(p.name, p.age, p.hobbys); 
	}
	Person2(String name, int age, String[]hobby) {
		this.name = name; //인스턴스가 된 자기자신
		this.age = age;
		int length = hobbySize;
		if(hobbySize>hobby.length) {
			length = hobby.length;
		}
		for(int i=0; i<length; i++) {
			this.hobbys[i]=hobby[i];
		}//배열의 값을 하나하나 복사해서 들어감
		//this.hobbys = hobby;
	}
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", hobbys=" + Arrays.toString(hobbys);
	}
	
}
class PersonTest2 {
	public static void main(String[] args) {
		String[] hobbys = {"자전거","등산"};
		Person2 p1 = new Person2("홍길동",30,hobbys);  //
		System.out.println(hobbys == p1.hobbys); //주소값을 비교
		
		Person2 p2 = new Person2(p1);
		//person p3 = new Person();
		
		System.out.println("p1:" +p1);
		System.out.println("p2:" +p2);
		
		hobbys[0] = "오토바이"; //
		//p1.hobbys[0] = "오토바이";
		System.out.println("p1:" +p1);
		System.out.println("hobbys: "+ Arrays.toString(hobbys));
		System.out.println("p2:" +p2);
	}

}
