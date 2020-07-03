package test0703;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		new TreeSetTest().go();
	}
	public void go() {
		//comparable이용
		Book b1 =new Book("How cats walk");
		Book b2 =new Book("Remix");
		Book b3 =new Book("Emo");
		TreeSet tree = new TreeSet();
		tree.add(b1); tree.add(b2); tree.add(b3);
		System.out.println("1:"+tree);
		//comparator 이용
		Book2 t1 = new Book2("How cats walk");
		Book2 t2 = new Book2("Remix");
		Book2 t3 = new Book2("Emo");
		
		TreeSet tree2 = new TreeSet(new BookCompare());
		tree2.add(t1); tree2.add(t2); tree2.add(t3);
		System.out.println("2:"+tree2);
		System.out.println("3:"+tree2.first());
		System.out.println("4:"+tree2.last());
		System.out.println("5:"+tree2.remove(new Book2("Emo")));
		System.out.println("6:"+tree2);
		tree2.add(t3);
		//인자보다 값이 작은 항목들의 집합
		SortedSet ss = tree2.headSet(new Book2("Remix"));
		System.out.println("7:"+ss);
		//인자보다 값이 크거나 같은 항목들의 집합
		SortedSet ss2 = tree2.tailSet(new Book2("Emo"));
		System.out.println("8:"+ss2);
		//SubSet(a,b) a이상 ~ b미만인 집합
		SortedSet ss3 = tree2.subSet(new Book2("Emo"),new Book2("Rimix"));
		System.out.println("9:"+ss3);
		
		TreeSet tree3 = (TreeSet) tree2.clone();
		System.out.println("10:"+tree3);
	}
}
class Book implements Comparable{
	private String title;
	
	public Book(String t) {
		title = t;
	}

	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + "]";
	}
	
	public int compareTo(Object obj) {
		Book book = (Book)obj;
		return title.compareTo(book.getTitle())*-1;
	}
}
class Book2{
	private String title;
	
	public Book2(String t) {
		title = t;
	}
	
	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return "Book2 [title=" + title + "]";
	}
	
}
class BookCompare implements Comparator {
	@Override
	public int compare(Object arg0, Object arg1) {
		return ((Book2)arg0).getTitle().compareTo(((Book2)arg1).getTitle());
	}
}
	
