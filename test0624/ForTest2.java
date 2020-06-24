package test0624;

public class ForTest2 {
	public static void main(String[] args) {
		Loop1 :
			for(int i=2; i<10; i++) {
				for(int j=1; j<10; j++) {
					if(j==5) {
						//break Loop1;
						break;
						//continue Loop1;
						//continue;
					}
					System.out.println(i+"*"+j+"="+i*j);
				}
				System.out.println();
			}
	}

}
