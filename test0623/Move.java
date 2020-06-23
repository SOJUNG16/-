package test0623;

import java.util.Scanner;

//•실습3: 배열원소 이동
//- 입력:1~10
//
//- 출력:[2,3,4,5,6,7,1]
//Int[] irr = {1,2,3,4,5,6,7}; 

public class Move {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int [] arr = {1,2,3,4,5,6,7}; 
		
		System.out.println("칸수입력:");
		int move = scanner.nextInt();
		int [] irr = {1,2,3,4,5,6,7};
		
		for(int i=0; i<move; i++) {
			int temp;
			temp = irr[0];
			for(int j=0; j<irr.length; j++) {
				irr[j-1] = irr[j];
			}
		}
		
		
		
	}
	
	
	

}
