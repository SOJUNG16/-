package matrix;

import java.util.Random;
import java.util.Scanner;

class Lotto{
	//int[] lotto;
	public boolean isDuplication(int[] lotto, int num) {
		boolean ok = false;
				for(int i=0; i < lotto.length; i++) {
						if(lotto[i] == num) ok = true;
	}
	 return ok;
}

}

public class LottoApp4 {
	public static void main(String[] args) {
		Random random = new Random();
		int [][] lottos = new int[5][6];
		Scanner scanner = new Scanner(System.in);
		Lotto instance = new Lotto();
		System.out.println("얼마치를 구입합니까?");
		System.out.println("1.1000원 2.2000원 3.3000원 4.4000원 5.5000원");
		int k = 0;
		k=scanner.nextInt();
		for(int j=0; j<k; j++) {
			for(int i=0; i<lottos.length; i++) {	// 번호생성
			int temp = random.nextInt(45)+1;
			System.out.printf("뽑힌값: %d\n", temp);
			if(instance.isDuplication(lottos[j], temp)) {
			   i--;
			   continue;
			}
			lotto[i] = temp;
		}
			
		}
		
		
		
		
		


