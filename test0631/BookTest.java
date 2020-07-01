package test0631;

abstract class Book { //인스턴스화 안됨 자식을 통해서 인스턴스화됨
	private int num;
	private String title;
	private String author;
	
	public Book() {
	}
	public Book(int num, String title, String author) {
		this.num = num;
		this.title = title;
		this.author = author;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	void getLateFee() {
		
	}
	@Override
	public String toString() {
		return "100원";
	}
	
}
class Animation extends Book{
	Animation() {
	}
	Animation(int num, String title, String author) {
		super(num, title, author);
	}
	
	void getLateFee() {
		
	}
	
	
}
class Science extends Book {
	Science() {
		
	}
	Science(int num, String title, String author) {
		super(num, title, author);
	}
	void getLateFee() {
		
	}
}

public class BookTest {
	public static void main(String[] args) {
		Animation ani = new Animation(1111,"제목","저자");
		
		
	}

}
