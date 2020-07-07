package assignment;

import java.util.Scanner;

//•실습2: 급여계산하기
//- 입력:기본급, 직책(사원/대리/과장/부장)
//- 출력:실수령액 =xxx원
//* 계산식은 다음과 같다
//
//- 실수령액 = 기본급 +직책수당 – 세금
//
//-세금 = 기본급의 10%
//* 직책 수당표
// 사원 대리 : 0
//- 과장: 200,000
//- 부장: 500,000

public class Money {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int [] arr = { 0, 0, 200000, 500000};
		int basic = 0, total = 0;
		String job = "";
		//double tax = basic * 0.1;
		
		//실수령액 = 기본급 +직책수당 – 세금
		//total = 기본금 +직책수당
		
		System.out.println("기본급을 입력하세요.");
		basic = scanner.nextInt();
		System.out.println("직책을 입력하세요.");
		job = scanner.next();
		switch (job) {
		case "사원": total = (basic + arr[0]);
			break;
		case "대리": total = (basic + arr[1]);
			break;
		case "과장": total = (basic + arr[2]);
			break;
		case "부장": total = (basic + arr[3]);
			break;
		}
		int result = (int) (total*0.9);
		System.out.println("실수령액= "+result+"원");
	}
	
	
	
}

