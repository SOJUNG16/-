package matrix;

public class MatrixBasic {
	public static void main(String[] args) {
		int[][] mtx = new int[5][5];
		for(int i=0; i<mtx.length; i++) {
			System.out.println("");
			for(int j=0; j<mtx[i].length; j++) {
				mtx[i][j] = 5;
		}
		}
		
		
//		int[][] mtx = new int[5][5];
//		for(int i=0; i< mtx.length; i++) { //아래로 내려감
//			System.out.println("");
//			for(int j=0; j< mtx[i].length; j++) { //옆으로 이동
//				System.out.printf("[%d, %d]", i,j);
//				mtx[i][j] = 5;
//			}
//			}
//		for(int i=0; i< mtx.length; i++) { 
//			System.out.println("");
//			for(int j=0; j< mtx[i].length; j++) { 
//				System.out.printf(mtx[i][j]+"\t"); //tap키 만큼 간격 띄우기
//		}
//		
//		}
	}
}


