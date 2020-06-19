package basic;

public class Teams {
	public static void main(String[] args) {
	
		String[][] teams = {{"길동", "순신", "강참", "철수"}, 
				{"톰", "제임스","칼","로빈"}, 
				{"제이콥", "기호","승아","태빈"}, 
				{"동준", "로미", "길수", "영희"}};
		for(int i=0; i< teams.length;i++) {
			for(int j=0; j< teams[i].length;j++) {
				System.out.printf("%s\t",teams[i][j]);
			}
			System.out.println();
		}
	}

}
