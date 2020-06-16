package matrix;
//5*5 행열 만들기
public class MatrixBasic {
	public static void main(String[] args) {
		int [][] mtx = new int[5][5];
		//입력
		int k = 1;
		for(int i=0; i<mtx.length; i++) {
			System.out.println();
			for(int j=0; j <mtx[i].length; j++) {
				mtx[i][j]= k++*10;
			}
		}
		//출력
		for(int i=0; i<mtx.length; i++) {
			System.out.println();
			for(int j=0; j <mtx[i].length; j++) {
				System.out.printf(mtx[i][j]+"\t");
			}
		}
	}
}


