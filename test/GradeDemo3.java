package test;

import java.util.Scanner;

/*[요구사항] 영어 점수에 따라 A ~ F 까지 등급을 부여하는 프로그램을 작성해 주시오.
100 ~ 90 A
89 ~ 80 B
79 ~ 70 C
69 ~ 60 D
59 ~ 50 E
49 ~ 0 F*/

public class GradeDemo3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("메뉴: 0.종료 1.실행");
			int flag = scanner.nextInt();
			switch(flag) {
			case 0 : System.out.println("종료"); return;
			case 1 : study(scanner); break;
			}
		}	
	}

	private static void study(Scanner scanner) {
		System.out.println("이름? ");
		String name = scanner.next();
		System.out.println("영어?");
		final String eng = "영어";
		System.out.println("점수?");
		int score = scanner.nextInt();
		String grade = "";
		
		if(score >= 90) {grade = "A";}
		else if(score >= 80) {grade = "B";}
		else if(score >= 70) {grade = "C";}
		else if(score >= 60) {grade = "D";}
		else if(score >= 50) {grade = "E";}
		else {grade = "F";}
		
		System.out.println("********************************");
		System.out.println("이름 영어 점수 등급");
		System.out.println("-----------------------------------");
		System.out.println("|"+name+"| "+eng+" | "+score+"| "+grade+" ");
	}
	

}
