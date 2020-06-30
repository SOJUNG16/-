package test0630;

class A6{
	public void aaa() {
		System.out.println("aaa");
	}
	public void bbb() {
		System.out.println("bbb");
	}
}
class B6 extends A6{
	public void bbb() {
		System.out.println("bbb1");
	}
	public void ccc() {
		System.out.println("ccc");
	}
}
public class PolymorTest {
	public static void main(String[] args) {
		A6 ap = new B6(); //B6(자식)이 A6(부모)를 ap를 이용해서 사용함
		ap.aaa();
		ap.bbb(); //오버라이딩된 B6의 bbb가 호출됨
		//ap.ccc();
	}

}
