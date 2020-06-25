package test0625;

import java.util.Arrays;

class Person{
	String name;
	int age;
	String [] hobbys; //하비의 사이즈를 정의 못함
					  //참조형변수
	Person() {
	}
	Person(Person p) {
		this(p.name, p.age, p.hobbys); //인스턴스화된 자기자신 파라미터 3개인 생성자 호출
									   //호출해서 name age hobbys 초기화
	}
	Person(String name, int age, String[]hobby) { 
		this.name = name;
		this.age = age;
		this.hobbys = hobby; //String은 주소값 저장 등호로 할당해서 같은 주소값들어감
	}
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", hobbys=" + Arrays.toString(hobbys);
	}
	
}

class PersonTest {
	public static void main(String[] args) {
		String[] hobbys = {"자전거","등산"}; //hobbys컵 여기서 넘겨주는 값이 String [] hobbys의 사이즈가 결정됨
		Person p1 = new Person("홍길동",30,hobbys);
		System.out.println(hobbys == p1.hobbys); //같은 주소가 됨
		
		Person p2 = new Person(p1);
		//person p3 = new Person();
		
		System.out.println("p1:" +p1);
		System.out.println("p2:" +p2);
		
		hobbys[0] = "오토바이"; 
		System.out.println("p1:" +p1);
		System.out.println("p2:" +p2);
	}

}
