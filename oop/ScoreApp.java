package oop;
import java.util.Scanner;
class Score{
	private String name;
	private int kor, eng, math, sum;
	float avg;
	
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	public void setKor(int kor) {this.kor = kor;}
	public int getKor() {return this.kor;}
	public void setEng(int eng) {this.eng = eng;}
	public int getEng() {return this.eng;}
	public void setMath(int math) {this.math = math;}
	public int getMath() {return this.math;}
	public void sum() {this.sum = this.kor + this.eng + this.math;}
	public void avg() {this.avg = this.sum / 3;}
	public float showAge() {return this.avg;}
	
	public String toString() {
		return "국어: "+kor+", 영어:"+eng+", 수학:"+math+", 합계:" +sum + "평균: " + avg;
			
	}
	
	
}
public class ScoreApp{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Score[] arr = new Score[2];
		for(int i=0; i<arr.length; i++) {
			Score student = new Score();
			System.out.println("이름: ");
			student.setName(scanner.next());
			System.out.println("국어점수: ");
			student.setKor(scanner.nextInt());
			System.out.println("영어점수: ");
			student.setEng(scanner.nextInt());
			System.out.println("수학점수: ");
			student.setMath(scanner.nextInt());
			student.sum();
			student.avg();
			System.out.println("평균: "+student.showAge());
			arr[i]=student;
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i].toString();
		}
	}
	
			
	
}