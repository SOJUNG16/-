package sequence;

import java.util.Scanner;

/* 1부터 합산하고자 하는 한계 숫자를 입력하시오
1부터 합산한 숫자(이하) 범위 내에서 홀수의 합을 출력하시오.
**/
public class InputSequence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("한계값 입력:");
		int lim = scanner.nextInt();
		int sum = 0;
		int [] arr = new int[lim];
		// arr 값 할당
		for(int i=0; i<lim; i++) {
			arr[i] = scanner.nextInt();
		}
		// 홀수 합계 구하기
		for(int i=0; i<lim; i=i+2) {
			sum += arr[i];
		}
		System.out.println(sum);
	}	
}
		
