package shop;

import java.util.Arrays;

public class Cart {
	public static final int MAX = 100;
	private Product[] prod;
	private int[] amount;
	private int totalPrice;
	private int cartCnt;
	
	public Cart () {
		this.prod = new Product[MAX];
		this.amount = new int[MAX];
	}
	
	public Product[] getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod[cartCnt] = new Product();
		this.prod[cartCnt] = prod;
		cartCnt++;
		
	}
	public void setProd(Product[] prod) {
		this.prod = prod;
	}

	public int[] getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount[cartCnt] = amount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getCartCnt() {
		return cartCnt;
	}

	public void setCartCnt(int cartCnt) {
		this.cartCnt = cartCnt;
	}


	
	@Override
	public String toString() {
		String result = "";
		System.out.println("[장바구니]");
		for(int i = 0; i < cartCnt; i++) {
			int tmp = this.prod[i].getPrice() * this.amount[i];
			result += this.prod[i].toString()
					+", 수량: "+ this.amount[i] + ", 금액: "+ tmp +"\n";
			this.totalPrice += tmp;
		}
		result += "-------------------------------------------\n"
				+ "총 금액: " + this.totalPrice;
		return result;
	}
	
	// int totalPrice 삭제
}
