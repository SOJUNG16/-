package assignment;

abstract class Book { //인스턴스화 안됨 자식을 통해서 인스턴스화됨
	protected int num;
	protected String title;
	protected String author;
	protected int day;
	
	public Book() {
	}
	public Book(int num, String title, String author,int day) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.day = day;
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
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	abstract void getLateFee(); //추상메서드
	
	@Override
	public String toString() {
		return ""+getNum()+" "+getTitle()+" "+getAuthor()+"";
	}
}
class Animation extends Book{
	Animation() {
	}
	Animation(int num, String title, String author,int day) {
		super(num,title,author,day);
	}
	@Override
	void getLateFee() {
		System.out.println(getDay()*300+"원");
	}
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Animation ) {
			return super.getNum()==(((Animation)obj).getNum());
		}else {
			return false;
		}
	}
}
class Science extends Book {
	Science() {
		
	}
	Science(int num, String title, String author, int day) {
		super(num,title,author,day);
	}
	@Override
	void getLateFee() {
		System.out.println(getDay()*200+"원");
	}
}

public class BookTest {
	public static void main(String[] args) {
		Animation ani = new Animation(1111,"제목","저자",2);
		Science sci = new Science(2222,"제목2","저자2",2);
		Animation ani2 = new Animation(1111,"제목3","저자3",2);
		
		ani.getLateFee();
		sci.getLateFee();
		System.out.println(ani.toString());
		System.out.println(sci.toString());
		
		System.out.println(ani.equals(ani2));
	}

}
