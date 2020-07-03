package test0703;

import java.util.HashSet;

public class SetTset {
	public static void main(String[] args) {
		HashSet set1 = new HashSet();
		set1.add("apple");
		set1.add("banana");
		System.out.println(set1.add("apple"));
		System.out.println(set1);
		System.out.println("contains:"+set1.contains("apple"));
		//추가,삭제
		HashSet set2 = (HashSet)set1.clone();
		set2.add("Melon");
		set2.remove("apple");
		System.out.println(set2);
		//합집합
		HashSet result = (HashSet)set1.clone();
		result.addAll(set2);
		System.out.println(result);
		//교집합
		HashSet result2 = (HashSet)set1.clone();
		System.out.println(result2);
		result2.retainAll(set2);
		System.out.println(result2);
		//차집합
		HashSet result3 = (HashSet)set1.clone();
		result3.remove(set2);
		System.out.println(result3);
		
		}
	}


