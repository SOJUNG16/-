package basic;

public class Names {
	public static void main(String[] args) {
		String[] names = {"a","b","c","d","e"};
		// ace  를 출력
		String ace = "";
		int i = 0;
		while(true) {
			if(i < names.length) {
				if(i % 2 == 0 ) {
					ace += names[i];
				}
				i++;
			}else {
				break;
			}
		}
		System.out.println(ace);
		
	}

}
