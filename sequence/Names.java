package sequence;

public class Names {
	public static void main(String[] args) {
		String[] name = {"a", "b", "c", "d", "e"};
		//ace 출력
		
		String sum = "" ; //string 초기값
		for(int i=0; i<name.length; i=i+2) {
			sum += name[i]; //sum = sum + name[i]
		}
		System.out.println(sum);
	
		
	}
}
