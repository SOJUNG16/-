package basic;

import java.util.Scanner;

/*
5명의 심사위원의 점수중에서 0 ~ 100점 만점에서 
 최고점과 최하점을 제외한 3명 점수평균구하기 
 * */
public class FigureScore {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum =0;
		int[] arr = new int[5];
		int max=0, min=100;
		for(int i=0;i < arr.length; i++) {
			System.out.println("점수: ");
			arr[i] = scanner.nextInt();
			sum += arr[i];
			if(max < arr[i]) max = arr[i];
			if(min > arr[i]) min = arr[i];
		}
		sum -= max;
		sum -= min;
		System.out.println("평균: "+sum/3);
	}
}











