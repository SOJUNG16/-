package test;
import java.util.Scanner;

public class ShopApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Shop[] shops = new shop[3];
		for(int i=0; i<3; i++) {
			Shop shop = new shop();
			System.out.println("�̸�: ");
			shop.setName(scanner.next());
			System.out.println("������: ");
			shop.setPhprice(scanner.nextInt());
			System.out.println("tv����: ");
			shop.settvprice(scanner.nextInt());
			System.out.println("��ǻ�� ����: ");
			shop.setcoprice(scanner.nextInt());
			shop.sum();
			shops[i]=shop;
		}
		for(int i=0; i<3; i++) {
			shops[i].printstates();
		}
	}

}
