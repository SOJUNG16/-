package test;

public class Shop {
	
	private String name;
	private int phprice,tvprice,coprice,sum;
	
	public void setName(String name) {
		this.name = name; 
	}
	public String getName() {
		return this.name;
	}
	public void setPhprice(int phprice) {
		this.phprice = phprice;
	}
	public int getphprice() {
		return this.phprice;
	}
	public void settvprice(int tvprice) {
		this.tvprice = tvprice;
	}
	public int gettvprice() {
		return this.tvprice;
	}
	public void setcoprice(int coprice) {
		this.coprice = coprice;
	}
	public int tvprice() {
		return this.coprice;
	}
	public void sum() {
		this.sum = this.phprice+this.tvprice+this.coprice;
	}
	
	void printstates() {
		System.out.println(""+name+"님 결제하실 총 금액은 "+sum+"만원 입니다");
	}

}
