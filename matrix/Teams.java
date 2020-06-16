package matrix;

public class Teams {
	public static void main(String[] args) {
//		String name = "길동";
//		String name2 = "순신";
//		String[] team1 = {"길동", "순신", "ㄱㄱ", "ㄴㄴ"}; 
//		String[] team2 = {"ㄷㄷ", "ㄹㄹ", "ㅁㅁ", "ㅂㅂ"};
//		String[] team3 = {"ㅅㅅ", "ㅇㅇ", "ㅈㅈ", "ㅊㅊ"};
//		String[] team4 = {"ㅋㅋ", "ㅌㅌ", "ㅍㅍ", "ㅎㅎ"};

		String[][] teams ={ {"길동", "순신", "ㄱㄱ", "ㄴㄴ"},
		                    {"ㄷㄷ", "ㄹㄹ", "ㅁㅁ", "ㅂㅂ"},
		                    {"ㅅㅅ", "ㅇㅇ", "ㅈㅈ", "ㅊㅊ"},
		                    {"ㅋㅋ", "ㅌㅌ", "ㅍㅍ", "ㅎㅎ"}};
		
		for(int i=0; i<teams.length; i++) {
			for(int j=0; j<teams[i].length; j++) {
				System.out.printf("%s\t",teams[i][j]);
			}
			System.out.println();
		}
	}
}

