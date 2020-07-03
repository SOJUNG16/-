package test0702;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayTest {
	public static void main(String[] args) {
		// 문제1.
		Integer[] arr = { 7, 5, 10, 9, 3, 5, 2, 8 };
		Arrays.sort(arr, new Descending());
		System.out.println(("문제1=" + Arrays.toString(arr)));

		// 문제2.
		String[] arr2 = { "AB", "ef", "CK", "gt", "pb" };
		Arrays.sort(arr2, new Descending());
		System.out.println(("문제2=" + Arrays.toString(arr2)));

		// 문제3.
		Integer[] arr3 = { 7, 5, 10, 9, 3, 5, 2, 8 };
		Integer[] Arr4 = { 5, 10, 15, 90, 7 };
        //181page
		List list = new ArrayList(Arrays.asList(7, 5, 10, 9, 3, 5, 2, 8));
		List list2 = new ArrayList(Arrays.asList(5, 10, 15, 90, 7));
		System.out.println("문제3");
		//겹치는 부분만 남기고 삭제
		System.out.println(list.retainAll(list2));
		print(list);

		System.out.println("문제4");
		//겹치는 부분만삭제
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list2.contains(list.get(i)))
				list.remove(i);
		}
		list2.addAll(list);
		print2(list2);

//		 문제5: 다음 클래스의 객체를 ArrayList에 담아서 오름차순으로 정렬하시오
//		 (age가 큰 것이 큰값으로 간주)
	List list3 = new ArrayList();
	list3.add(new Dog("낙동", 5));
	list3.add(new Dog("샤크", 3));
	list3.add(new Dog("동해", 7));
	
	Collections.sort(list3);
	System.out.println("문제5");
	System.out.println(list3.toString());
	
	}
	
	static void print(List list) {
		System.out.println("list:" + list);
	}
	
	static void print2(List list2) {
		System.out.println("list2:" + list2);
	}	
	
	static void print3(List list3) {
		System.out.println("list3:" + list3);
	}	
}

	class Dog  implements Comparable{
		String name;
		int age;
		
		Dog(String name, int age){
			this.name=name;
			this.age=age;
		}
		
		 @Override
		public String toString() {
			return "name=" + name + ", age=" + age + "";
		}

		public int compareTo(Object p) {
		        if(this.age > ((Dog)p).age) {
		            return 1; 
        }
		return -1;
	}
}
class Descending implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;

			return c1.compareTo(c2) * -1; 
		}
		return -1;
	}
}