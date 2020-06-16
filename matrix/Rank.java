package matrix;
import java.util.Random;
/*
 * 5명의 점수를 입력받아서 1등 90점, 2등86점, 3등 77점, 4등 66점, 5등 40점으로 출력
 * 행렬을 반드시 사용
 * 점수 받는 배열 등수를 가지고 있는 배열을 만들고 그걸 매트리스화
 */
import java.util.Scanner;

public class Rank { 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int scores[] = new int[5];
		int rank[] = new int[5];
		for(int i=0; i<rank.length; i++) {
			scores[i] = random.nextInt(101);
			rank[i] = 1;
		}
		for(int i=0; i<rank.length; i++) {
			for(int j=0; j<rank.length; j++) {
				if(scores[i] < scores[j]) {
					rank[i]++;
				}
			}
		}
		for(int i=0; i <rank.length; i++) {
			System.out.printf(" %d 등 : %d 점\n",rank[i], scores[i]);
		}
	}
}
