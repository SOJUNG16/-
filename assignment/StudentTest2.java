package assignment;
//• 실습: 학원시스템

import java.util.Scanner;

class Student1 {
	int stuid; 
	String stuname;
	
	@Override
	public String toString() {
		return "학생: "+ stuid + "/"+ stuname +"";
	}
}
class Teacher {
	int teaid;
	String teaname;
	
	@Override
	public String toString() {
		return "강사: " + teaid +"/" + teaname + "";
	}
}

public class StudentTest2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int stucount = 0;
		int teacount = 0;
		Student2 [] stus = new Student2[100];
		Teacher [] teas = new Teacher[100];
		Student2 student = null; //Student student = new Student();
		Teacher teacher = null;//Teacher teacher = new Teacher();
		while (true) {
			System.out.println("선택하세요. [0:나가기, 1:학생등록, 2:강사등록, 3. 관련자 조회, 4. 강의등록, 5:강의조회]");
			switch (scanner.nextInt()) {
			case 0 : System.out.println("나가기"); return;
			case 1 : //1.학생등록
				student = new Student();
				System.out.println("[학생등록]");
				System.out.println("학생번호를 입력하세요");
				student.stuid = scanner.nextInt();
				System.out.println("학생이름을 입력하세요");
				student.stuname = scanner.next();
				
				boolean flag = false;
				for(int i=0; i<stucount; i++) { //count값 고정
					if(student.stuid == stus[i].stuid) {
						System.out.println("'학생번호가 중복됩니다'");
							flag = true;	
							break;
					}
				}
					if (flag == false) {
						stus[stucount] =student;
						stucount++;
						break;
						}
			case 2 : //2.강사등록
				teacher = new Teacher();
				System.out.println("[강사등록]");
				System.out.println("강사번호를 입력하세요");
				teacher.teaid = scanner.nextInt();
				System.out.println("강사이름을 입력하세요");
				teacher.teaname = scanner.next();
				
				boolean flag2 = false;
				for(int j=0; j<teacount; j++) {
					if(teacher.teaid == teas[j].teaid) {
					System.out.println("'강사번호가 중복됩니다'");
						flag2 = true;
						break;
					}
				}
					 if(flag2 == false) {
						teas[teacount] = teacher;
						teacount++;
						 break;
					}
					
			case 3: //3.관련자조회
				int num=0;
				System.out.println("[관련자조회]");
				System.out.println("관련자유형(학생(10)/강사(20)): ");
				num = scanner.nextInt();
				if(num==10) {
					System.out.println("학생번호를 입력하세요");
					int stuid = scanner.nextInt();
					for(Student s : stus) {
						if(s !=null && stuid == s.stuid) {
							System.out.println(s.toString());
						}
					}
					
				}
				if(num==20) {
					System.out.println("강사번호를 입력하세요");
					int teaid = scanner.nextInt();
					for(Teacher t : teas) {
						if(t != null && teaid == t.teaid) {
							System.out.println(t.toString());
						}
					}
					
				}
			}break;		
		}
	}
}

