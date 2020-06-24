package test0624;

import java.util.Scanner;

public class FlowEx27 {
	public static void main(String[] args) {
		int num;
		int sum =0;
		boolean flag = true;
		
		System.out.println("합계를 구할 숫자를 입력하세요.(끝내려면 0을 입력)");
		
		while(flag) { //flag = true 무한반복 false바꿔서 While끝내기
			System.out.println(">>");
			
			Scanner scanner = new Scanner(System.in);
			String tmp = scanner.next();
			num = Integer.parseInt(tmp);
			
			if(num!=0) {
				sum += num; //num이 0이 아니면 sum = sum+num
			} else {
				flag = false; //num이 0이면 flag의 값을 false로 변경
			}
		}
		 System.out.println("합계:" +sum);
	}

}
