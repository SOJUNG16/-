package test;

import java.util.Scanner;

class GradeDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = new int[3];
		for(int i=0; i<3; i++) {
			System.out.println("학생점수?");
			arr[i] = scanner.nextInt();
		}
		
		int result = 0; // int에서 시작하는 기본값
	    if( arr[0] > arr[1] && arr[0] > arr[2] ) {
			result = arr[0];
		} else if ( arr[1] > arr[0] && arr[1] > arr[2]) {
			result = arr[1];
		} else { result = arr[2];
		}
		System.out.println(result);	
	    }
}


