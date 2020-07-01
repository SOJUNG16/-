package test0631;

public class MathTest {
	public static void main(String[] args) {
		double val = 90.7552;
		System.out.println(Math.round(val));// 반올림 91
		
		val *= 100;
		System.out.println(Math.round(val)); // 반올림 9075.52 -> 9076
		System.out.println(Math.round(val)/100); // 반올림 90
		System.out.println(Math.round(val)/100.0); //반올림 90.76
		System.out.println();
		System.out.println(Math.ceil(1.1)); // 올림 2
		System.out.println(Math.floor(1.5));// 버림 1
		System.out.println(Math.round(1.1)); // 1
		System.out.println(Math.round(1.5)); // 2
		System.out.println(Math.rint(1.5)); // 
		System.out.println(Math.round(-1.5));
		System.out.println(Math.rint(-1.5));
		System.out.println(Math.ceil(-1.5));
		System.out.println(Math.floor(-1.5));
	}

}
