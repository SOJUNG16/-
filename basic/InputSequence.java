package basic;

import java.util.Scanner;

/*
1부터 합산하고자 하는 한계 숫자를 입력하시오
1부터 합산한 숫자(이하)범위내에서 수의 합을 출력하시오. 
 * */
public class InputSequence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("한계값 입력:");
		int lim = scanner.nextInt();
		int sum = 0;
		for(int i=0;i < lim;i++) {
			if((i+1) % 2 != 0) sum += (i+1);
		}
		System.out.println(sum);
	}
}
