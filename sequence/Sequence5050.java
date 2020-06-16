package sequence;

public class Sequence5050 {
	public static void main(String[] args) {

		int [] arr = {1, 2, 3, 4, 5} ;
		int sum = 0;
		for(int i=1; i<arr.length; i=i+2) {
			sum += arr[i]; // sum = sum + arr[1]
		} // i++ == i=i+1 == i+=1
		System.out.println(sum);
	}
}
