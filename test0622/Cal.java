package test0622;

public class Cal {
	public static void main(String[] args) {
		//논리연산자
		int x =15;
		System.out.println(10>x && x++<20);
		System.out.println("x=" +x);
		System.out.println(10<x || x++<20);
		System.out.println("x=" +x);
		
		System.out.println(10>x & x++<20);
		System.out.println("x=" +x);
		System.out.println(10<x | x++<20);
		System.out.println("x=" +x);
		
		//조건연산자
		int y,z;
		int absX, absY, absZ;
		char signX, signY, signZ;
		
		x=0;
		y=-5;
		z=0;
		
		absX = x>=0 ? x:-x;
		absY = y>=0 ? y:-y;
		absZ = z>=0 ? z:-z;
		
	}
}
