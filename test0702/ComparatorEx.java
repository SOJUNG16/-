package test0702;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
	public static void main(String[] args) {
		String [] strArr = {"cat","Dog","lion","tiger"};
		
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분안함
		System.out.println(Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());
		System.out.println(Arrays.toString(strArr));
	}

}
class Descending1 implements Comparator {
	public int compare(Object o1, Object o2 ) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o1;
			return c1.compareTo(c2)*-1; //정방향 *-1 역방향을 만들어줌
		}
		return-1;
	}
	
}
