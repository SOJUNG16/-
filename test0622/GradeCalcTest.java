package test0622;

import java.util.Scanner;

public class GradeCalcTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 = ");
		int kor = Integer.parseInt(scanner.nextLine());
		System.out.println("영어 = ");
		int eng = Integer.parseInt(scanner.nextLine());
		System.out.println("수학 = ");
		int math = Integer.parseInt(scanner.nextLine());
		int tot = (kor+eng+math);
		float avg = tot/3.0f;
		System.out.printf("총점: %d점%n", tot);
		System.out.printf("평균: %.2f점%n", avg);
		
		if(avg>90) {
			System.out.println("A");
		} else if(avg>80) {
			System.out.println("B");
		} else if(avg>70) {
			System.out.println("C");
		} else if(avg>60) {
			System.out.println("D");
		} else System.out.println("E");
		
	}

}
