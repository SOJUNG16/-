package test0630;

interface interA2{
	void aaa();
	public abstract void bbb();
}
class interB2 implements interA2{
	public void aaa() {
		System.out.println("aaa메서드");
	}
	public void bbb() {
		System.out.println("bbb메서드");
	}
}
public class InterfaceTest2 {
	public static void main(String[] args) {
		interA2 bp = new interB2();
		bp.aaa();
		bp.bbb();
	}

}
