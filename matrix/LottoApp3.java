package matrix;

import java.util.Scanner;

class Lotto3 {
	private int limit;
	public void setLimit(int limit) {this.limit = limit;}
	public int getLimit() {return this.limit;}
	public int buy(int money) {
		int count = 0;
		if(money <1000) {
			System.out.println("잘못된 값");
		}else {
			if(limit < money/1000 ) {
				count = money/1000;
			} else {
				count = limit;
			}
		}
		return count;
	}
}

public class LottoApp3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("구매제한설정");
		Lotto3 lot = new Lotto3();
		lot.setLimit(scanner.nextInt());
		while(true) {
			System.out.println("0.종료 1. 로또구입");
			switch (scanner.nextInt()) {
			case 0: System.out.println("종료"); return;
			case 1: System.out.println("구입"); 
			System.out.println("입금액: ");
			System.out.printf("로또 d%장 발급합니다", lot.buy(scanner.nextInt()));break;
			} 
		}
	}
}

