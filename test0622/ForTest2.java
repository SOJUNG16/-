package test0622;

public class ForTest2 {
	public static void main(String[] args) {
		//구구단 출력
		Loop1 :
			for(int i=2; i<=9;i++) {
				for(int j=1; j<=9; j++) {
					if(j==5)
						//break Loop1; //2단 4까지
						//break; //9단4까지
						//continue Loop1; //9단 4까지
						continue;//9까지 전체결과
						System.out.println(i+"*"+j+"="+ i*j);
				}
				System.out.println();
			}
			
	}

}
