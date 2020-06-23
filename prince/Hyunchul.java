package prince;

import president.Daejung;
import president.Youngsam;

public class Hyunchul extends Youngsam {
	private int aa = 50;
	int bb = 50;
	protected int cc =50;
	public int dd = 50;
	
	public static void main(String[] args) {
		Hyunchul hc = new Hyunchul();
		System.out.println(hc.c);
		System.out.println(hc.d);
		
		Daejung dj = new Daejung(); //관계없는 클래스 public
		System.out.println(dj.d);
		
	}

}
