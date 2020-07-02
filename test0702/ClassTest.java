package test0702;

public class ClassTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		A a = new B();
		//Class 클래스의 인스턴스는 자바상에서 Class 들을 표현한다
		Class c1 = a.getClass(); //Object의 runtime상의 class를 반환한다
		System.out.println("class name:"+c1.getName());
		System.out.println("super class name:" +c1.getSuperclass());
		//새로운 인스턴스 생성
		B b = (B)(c1.newInstance());
		b.m2();
		Class c2 = Class.forName("test0702.B"); //B에 있는 클래스 정보를 가져오는것 
		((A) c2.newInstance()).m();
		System.out.println("abc".getClass().getName());
	}
}
class A{
	public int i;
	public A() {
		System.out.println("A 생성자");
	}
	public void m() {
		System.out.println("A.m()");
	}
}
class B extends A {
	public B() {
		System.out.println("B 생성자");
	}
	public void m() {
		System.out.println("B.m()");
	}
	public void m2() {
		System.out.println("B.m2()");
	}
}
