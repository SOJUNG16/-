package test0702;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
	public static void main(String[] args) {
//		int[] arr = {0,1,2,3,4};
//		int [] arr2 = Arrays.copyOf(arr, arr.length);
//		int [] arr3 = Arrays.copyOfRange(arr, 2,4);
//		for(int i =0; i<arr3.length; i++) {
//			System.out.println(arr3[i]);
//		}
		
//		int[] arr = new int[5];
//		Arrays.fill(arr, 9);
//		for(int i =0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
//		int[]arr = {3,2,0,1,4};
//		Arrays.sort(arr);
//		int idx = Arrays.binarySearch(arr, 2);
//		for(int i =0; i<idx; i++) {
//			System.out.println(arr[i]);
//		}
		int[] arr = {0,1,2,3,4};
		int [][] arr2 = {{11,12},{21,22}};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr2));
		
		List list = Arrays.asList(new Integer[] {1,2,3,4,5});
		List list2 = new ArrayList(Arrays.asList(1,2,6,4,5));
		System.out.println(list2);
	}
}
