package shop2;

public class Member {
	private String id, pw, name;
	private int point;
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", point=" + point + "]";
	}
	
	public Member() {
		this.cart = new Cart();
		
	}
	
	

}
