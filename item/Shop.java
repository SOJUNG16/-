package item;

import java.util.Scanner;

public class Shop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Item item = null;
		ItemService itemservice = new ItemServiceImpl();
		
		while(true) {
			System.out.println("메뉴 :  0.EXIT 1.ADD 2.LIST");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("EXIT"); return;
			case 1 : 
				item = new Item();
				itemservice.addCart(item);
				
				System.out.println("ADD");
				System.out.println("상품명 : ");
				item.setName(scanner.next());
				System.out.println("상품가격 : ");
				item.setPrice(scanner.nextInt());
				break;
			case 2 :
				System.out.println("LIST");
				Item [] list = itemservice.list();
				for (int i=0; i < list.length; i++) {
				System.out.println("item[i].toString()");
				break;
				}
			default : System.out.println("메뉴에 없는 기능입니다");
			break;
				
			}
		}
	}
	
}
	


