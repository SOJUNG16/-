package one;

import java.util.Scanner;
/**
  @author SOJUNG
  @since 2020.06.18
  @param kind 폰종류, company 제조사, call 통화내역
 */
//장바구니에 담기(celphone + tv) 다중부모X 다중자식O
class Product {
}
class TV extends Product {
	public final static String KIND = "TV";
	@Override public String toString() 
	{return String.format("%s", KIND);} //메인 메소드에서 출력
}
class ColorTV extends TV{
	public final static String KIND ="컬러티비";
	@Override public String toString() 
	{return String.format("%s", KIND);}
}
class Computer extends Product {
	public final static String KIND ="컴퓨터";
	@Override public String toString() 
	{return String.format("%s", KIND);}
}
class Notebook extends Computer{
	public final static String KIND = "노트북";
	@Override public String toString()
	{return String.format("%S", KIND);}
}
class Iphone extends Product {
	public final static String KIND = "아이폰";
	protected String search;
	public String getSearch() {return search;}
	public void setSearch(String search) {this.search = search;}
	public String toString() {
		return String.format("%S", KIND);
	}
}
class GalPhone extends Iphone{
	public final static String KIND = "갤럭시";
	protected String pay;
	public String getPay() {return pay;}
	public void setPay(String pay) {this.pay = pay;}
	public String toString() {
		return String.format("%S", KIND);
	}
	//[삼성] 갤럭시 제품을 사용해서 [이동중]에 [삼성페이결제]한다.
}
//extends Object
public class Etland {
	public static void main(String[] args) {
		//copy
		Scanner scanner = new Scanner(System.in);
		Product item = null;
		Product[] cart = new Product[5];
		int index = 0;
		while(true) {
			System.out.println("쇼핑목록 : 0.종료 1.아이폰 2.갤럭시 3. 컬러TV "
					+ "4.컴퓨터 5.노트북 6. 쇼핑목록보기");
			switch(scanner.nextInt()) {
			case 0 : return;
			case 1 : cart[index] = new Iphone(); index++; break;
			case 2 : cart[index] = new GalPhone(); index++; break;
			case 3 : cart[index] = new ColorTV(); index++; break;
			case 4 : cart[index] = new Computer(); index++; break;
			case 5 : cart[index] = new Notebook(); index++; break;
			case 6 :
				System.out.println("구매목록:");
				for(Product p : cart) {
					System.out.println(p.toString());
				}
//				for(int i=0; i<cart.length; i++) {
//					System.out.println(cart[i].toString());
//				}
				//Iphone ip = (Iphone)cart[index]; //down
			default:
				break;
			}
			}
		}
		
	}
