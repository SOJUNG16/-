package test0624;

public class ArrayEx5 {
	public static void main(String[] args) {
		int sum=0;          //총점을 저장하기 위한 변수
		float avg = 0f; // 평균을 저장하기 위한 변수
		
		int[] score1 = {100,88,100,100,90};
		//int [] score = new int[] {100,88,100,100,90};
		//int [] score = new int[5];
		//score[0]=100; score[1]=88; score[2]=100; score[3]=100; score[4]=90;
		
		for(int i=0; i<score1.length; i++) {
			sum += score1[i]; //sum= sum+score[i]
		}
		
		avg = sum/(float)score1.length;
		
		System.out.println("총점: "+sum);
		System.out.println("평균: "+avg);
	}

}
