package test0623;

public class InnerEX1 {
	int m =0;
	class InstanceInner {
		int iv = 100;
		int t = m;
		//static int cv = 100;
		final static int CONST = 100;
	}

static class StaticInner {
	int iv =200;
	//int t = m;
	static int cv = 200;
}
void method() {
	class LocalInner {
		int iv = 300;
		int i =m;
		//static int cv =300;
		final static int CONST = 300;
	}
}
public static void main(String[] args) {
	System.out.println(InstanceInner.CONST);
	System.out.println(StaticInner.cv);
}
LocalInner = new LocalInner();
}
InnerEx1 ex = new InnerEx1();
InnerEx1.InstanceInner inner1 = ex.new InstanceInner();
InnerEx1.StaticInner inner2 = new InnerEx1.StaticInner();
