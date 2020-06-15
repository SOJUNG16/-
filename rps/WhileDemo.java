package rps;

import java.util.Scanner;

public class WhileDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("메뉴: 0.종료 1.실행");
			int flag = scanner.nextInt();
			switch(flag) {
			case 0 : System.out.println("게임종료"); return;
			case 1 : System.out.println("게임실행"); break;
			}
			
	}
	
	}
	

}
