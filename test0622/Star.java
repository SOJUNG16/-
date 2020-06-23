package test0622;

public class Star {
	public static void main(String[] args) {
		for(int i =2;i<10;i++) {
			for(int j=0;j<(i-1);j++) {
			System.out.printf("%s",'*');
			}			
			System.out.println();
		}	
	}
}