package matrix;
import java.util.Random;

/*
 * 5명의 점수를 입력받아서 1등 90점, 2등86점, 3등 77점, 4등 66점, 5등 40점으로 출력
 * 행렬을 반드시 사용
 * 점수 받는 배열 등수를 가지고 있는 배열을 만들고 그걸 매트리스화
 */

public class Rank3 {
	public static void main(String[] args) {
	
		//입력
		Random random = new Random();
		int [] arr = new int[5];
		for(int i=0; i<arr.length; i++ ) {
			arr[i] = random.nextInt(101);
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j = 0; i > j; j++) {
				if(arr[j] < arr[i]) {
			          int t =arr[i];
			          arr[i] = arr[j];
			          arr[j] = t;
				}
			}	
		}
		//출력
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d등 %d점\n", (i+1) ,arr[i]);
			
		}
	}
}