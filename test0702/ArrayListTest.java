package test0702;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1); //값추가
		list.add(2);
		list.add(3);
		list.add(null); // null값도 add가능
		list.add(1,10); // index 1뒤에 10 삽입
		System.out.println(list);
		
		ArrayList list2 = new ArrayList();
		Student student = new Student("박찬호",28);
		list2.add(student); //객체 추가 가능
		list2.add(new Student("홍길동",15));
		System.out.println(list2);
		
		ArrayList list3 = new ArrayList(list);
		list3.remove(1); //index 1 제거
		System.out.println(list3);
		list3.clear(); //모든 값 제거
		System.out.println(list3);
		System.out.println(list3.isEmpty());
		
		ArrayList list4 = new ArrayList(list);
		System.out.println(list4.contains(1)); //list에 1이 있는지 검색 : true
		System.out.println(list4.indexOf(1)); //1이 있는 index반환 없으면 -1
		list4.addAll(list2);
		System.out.println(list4);	
	}
}
class Student{
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
}
	
	
