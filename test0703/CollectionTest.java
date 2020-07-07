package test0703;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CollectionTest {
	static HashMap map = new HashMap();
	
	public static void main(String[] args) {
		List list = new ArrayList();
		//왼쪽으로 3칸이동
		Collections.addAll(list, 7,5,10,9,3,5,2,8);
		Collections.rotate(list, -3);
		System.out.println("문제1");
		System.out.println(list);
		System.out.println();
		
		Set set = new HashSet();
		
		for(int i =0; set.size()<20; i++) {
			int num = (int)(Math.random()*100)+1;
			set.add(new Integer(num));
		}
		List list2 = new LinkedList(set);
		Collections.sort(list2);
		System.out.println("문제2");
		System.out.println(list2);
		System.out.println("최대값:"+Collections.max(list2));
		System.out.println("최소값:"+Collections.min(list2));
		System.out.println();
		
		HashSet set2 = new HashSet();
		set2.add(new Dog("강아지","3살"));
		set2.add(new Dog("강아지","3살"));
		set2.add(new Dog("강아지2","5살"));
		System.out.println("문제3");
		System.out.println(set2);
		
		HashMap hm = new HashMap();
		hm.put("100001",new Employee("홍길동",28,"인사팀"));                                                 
		addEmployee("100000","박길동",28,"총무팀");
		addEmployee("100003","박찬호",28,"회계팀");
		addEmployee("100002","이순신",28,"총무팀");
		
}

static void addNum(String num) {
	if(!map.containsKey(num)) {
		map.put(num, new HashMap()); 
	}	
}
static void addEmployee(String num, String name, int age, String Dep) {
	addNum(num);
	HashMap employee = (HashMap)map.get(num);
	employee.put(Dep, name);
}

class Dog{
	String name;
	String age;
	
	public Dog(String name,String age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Dog) {
			Dog tmp = (Dog)obj;
			return name.equals(tmp.name) && age==tmp.age;
		}
		return false;
	}
	public int hashCode() {
		return Objects.hash(name,age);
	}
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + "]";
	}
}

class Employee {
	String name,age,Dept;
	
}
