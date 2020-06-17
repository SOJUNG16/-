package matrix;

import java.util.Random;
import java.util.Scanner;

class Lotto2 {
	private int countLimit, lottoCount;
	private int[] lotto; //sorting된 상태로 저장
	private int[][] lottos;
	
	public void setCountLimit(int countLimit) {
		this.countLimit = countLimit;
	}
	public int getCountLimit() {
		return countLimit;
	}
	public void setLottos(int[][] lottos) {
		lotto = new int[6];
		lottos = new int[lottoCount][6];
		for(int i=0; i< lottoCount; i++) {
			for(int j=0; j<6; j++) {
				//로또 넘버
				int num = (int)(Math.random() *45) +1;
				while(isDuplication(num)) {
					lotto[j]=num;
					break;
				}
			}
			sort(lotto);
			System.arraycopy(lotto, 0, lottos[i], 0, lotto.length);
			//arry를 Matrix에 한줄씩 입력하는 방법
			
		}
		this.lottos = lottos;
	}
	public int[][] getLottos() {
		setLottos(lottos);
		return this.lottos;
	}
	public void sort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j< arr.length; j++) {
				if(arr[i] > arr[j]) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
		this.lotto = arr;
	}
	public int lottocount(int money) {
		int lottocount = 0;
		if(money < 1000 ) {
			System.out.println("잘못된값");
		} else { 
			if ( money > countLimit * 1000) {
					lottocount = countLimit;
			} else {
					lottocount = money / 1000;
			} 	
		}
		this.lottoCount = lottoCount;
		return lottocount;
	}
	//중복값
	public boolean isDuplication(int num) {
		boolean ok = false;
		for(int i=0; i < lotto.length; i++) {
			if(lotto[i] != num) ok = true;
		}
		return ok;
	}
}
	public class LottoApp2 {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			Lotto2 instance = new Lotto2();
			System.out.println("구매한도 설정");
			instance.setCountLimit(scanner.nextInt());
			System.out.printf("설정된 구매한도 %d 장\n", instance.getCountLimit());
			while(true) {
				System.out.println("0.종료 1. 로또구입");
				switch(scanner.nextInt()) {
				case 0 : System.out.println("종료"); return;
				case 1 : System.out.println("로또 구입"); buyLottos(instance, scanner); break;
				}
			}
		}
		public static void buyLottos(Lotto2 instance, Scanner scanner) {
			System.out.println("얼마치를 구입합니까?");
			System.out.printf("로또 %d장을 발급합니다\n", 
							instance.lottocount(scanner.nextInt()) );
			int[][] lottos = null;
			lottos = instance.getLottos();
			
			for(int i =0; i < lottos.length; i++) {
				for(int j=0; j <lottos[i].length; j++) {
					System.out.println(lottos[i][j]+"\n");
				}
				System.out.println();
			}
		}
	}




