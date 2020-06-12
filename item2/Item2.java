package item2;

public class Item2 {
	public String name;
	public int price;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	public String toString() {
		return " [상품명 : "+name+", 제품가격 : "+price+"] ";
	}
}
