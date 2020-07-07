package test0707;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GenericTest {
	public static void main(String[] args) {
		ArrayList<String> arrList = new ArrayList<String>(); //arrList에는 String만 담을수 잇음
		
		arrList.add("박지성");
		arrList.add("손흥민");
		arrList.add("기성용");
		String str = arrList.get(1); 
		System.out.println(str);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);
		list.add(789);
		int i = list.get(1);
		System.out.println(i);
		
		//다형성
		ArrayList<Sports> arrList2 = new ArrayList<Sports>();
		arrList2.add(new Sports());
		arrList2.add(new Soccer());
		arrList2.add(new Baseball());
		
		Sports sports = arrList2.get(0);
		
		//정렬
		String[] strArr = {"cat","Dog","lion","tiger"};
		Arrays.sort(strArr, new Descending2());
		System.out.println(Arrays.toString(strArr));
	}
}
class Sports{}

class Soccer extends Sports{}

class Baseball extends Sports{}

class Descending2 implements Comparator<String> {
	public int compare(String c1, String c2) {
		return c1.compareTo(c2)*-1;
	}
}
