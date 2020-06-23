package president;

import prince.Hyunchul;

public class Daejung {
	private int a = 70;
	int b = 70;
	protected int c =70;
	public int d = 70;
	
	public static void main(String[] args) {
		Daejung dj = new Daejung();
		System.out.println(dj.a);
		System.out.println(dj.b);
		System.out.println(dj.c);
		System.out.println(dj.d);
		
		Youngsam ys = new Youngsam(); // 같은 패키지
		System.out.println(ys.b);
		System.out.println(ys.c);
		System.out.println(ys.d);
		
		Hyunchul h = new Hyunchul(); //다른 패키지
		System.out.println(h.c);
		System.out.println(h.d);
		System.out.println(h.dd);
		
		
		
	}

}
