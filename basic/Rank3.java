package basic;

import java.util.Random;
/*
 * 5명의 점수를 입력받아서 1등 90점, 2등 86점, 3등 77점, 4등 66점, 5등 40점
 * 으로 출력하시오. 출력시 행렬을 반드시 사용하시오. 
 * */
public class Rank3 {
	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[5];
		for(int i=0; i< arr.length;i++) {
			arr[i] = random.nextInt(101);
		}
		for(int i=0; i< arr.length; i++) {
			for(int j= 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
		for(int i=0; i< arr.length;i++) {
			System.out.printf("%d등 %d점\n", (i+1), arr[i]);
		}
		
	}
}
