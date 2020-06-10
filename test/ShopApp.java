package test;
import java.util.Scanner;

public class ShopApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Shop[] shops = new Shop[3];
		for(int i=0; i<3; i++) {
			Shop shop = new Shop();
			System.out.println("이름: ");
			shop.setName(scanner.next());
			System.out.println("폰가격: ");
			shop.setPhprice(scanner.nextInt());
			System.out.println("tv가격: ");
			shop.settvprice(scanner.nextInt());
			System.out.println("컴퓨터가격: ");
			shop.setcoprice(scanner.nextInt());
			shop.sum();
			shops[i]=shop;
		}
		for(int i=0; i<3; i++) {
			shops[i].printstates();
		}
	}

}
