package test0701;

import java.util.HashSet;
import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random r = new Random(100);
		System.out.println((int)(r.nextDouble()*10));
		System.out.println((int)(r.nextDouble()*10));
		System.out.println((int)(r.nextDouble()*10));
		
		HashSet hs = new HashSet();
		Random ro = new Random();
		int cnt =0;
		while(true) {
			int value = ro.nextInt(46);
			if(hs.add(new Integer(value))) { cnt++;}
			if(cnt == 6) break;
		}
		System.out.println(hs);
		
	}

}
