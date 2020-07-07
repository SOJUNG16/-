package assignment;

import java.util.Scanner;

//• 실습:
//선택하세요. [0:나가기, 1:학생입력, 2:학생수출력, 3:학과별 학점평균,4:학생목록출력]
//[학생입력]
//학번: 111
//이름: 홍길동
//학과: 수학과
//학점: 90
//
//[학과수 출력]
//총학생수: 5
//평균점수: 85
//
//[학과별 학점평균]
//학과를 입력하세요: 수학과
//평균점수: 85
//
//
//[학생목록출력]
//학번: 111
//이름: 홍길동
//학과: 수학과
//학점: 90
//------------
//
//학번: 112
//이름: 김길동
//학과: 국학과
//학점: 85
//
//* 선택 후 작업 수행하면 다시 ‘선택하세요’가 나타난다
//* 학과: 수학과,국어과, 영어과
// 입력받고 받은걸 배열에 넣기
class Student {
	int score;
	String id, name, major;
}
public class StudentTest {
	public static void main(String[] args) {
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		Student [] students = new Student[100];
		
		while(true) {
		System.out.println("선택하세요. [0:나가기, 1:학생입력, 2:학생수출력, 3:학과별 학점평균,4:학생목록출력]");
		switch (scanner.nextInt()) {
		case 0: System.out.println("나가기"); return;
		case 1: //학생입력
			Student stu = new Student();
			
			System.out.println("[학생입력]");
			System.out.println("학번: ");
			stu.id = scanner.next();
			System.out.println("이름: ");
			stu.name = scanner.next();
			System.out.println("학과: ");
			stu.major = scanner.next();
			System.out.println("학점: ");
			stu.score = scanner.nextInt();
			
			students[count] = stu; //입력한 정보의 주소가 배열에 들어감
			count++;
			break;
		case 2: //학생수 + 평균 출력
			int sum=0;
			for(Student s: students) { //Student에 대한 값을 받기 때문에 Student s
				if(s != null) {
					sum += s.score; //데이터 2개 입력했을때 3번째에 접근하면 null오류나옴
				}
			}
			System.out.println("총학생수: +count");
			System.out.println("평균점수: +sum/(float)count");
			break;
		case 3: //3:학과별 학점평균
			System.out.println("학과를 입력하세요");
		}
			
						
			
			
			
			
			
		default:
			break;
	}
		
		
		}
	}


