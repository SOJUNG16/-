package test0624;

import java.util.Scanner;

public class FlowEx17 {
	public static void main(String[] args) {
		int num=0;
		
		System.out.println("*을 출력할 라인의 수를 입력하세요");
		
		Scanner scanner = new Scanner(System.in);
		String temp = scanner.next();
		num = Integer.parseInt(temp); //문자를 정수로 변환
	
		for(int i=0; i<num; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
}
