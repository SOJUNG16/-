package one;

import java.util.Scanner;

/* 요구사항 (기능정의)
* Person(id,pass,name) 
*       - Student(ssn :String <ex900101 - *******>, score : int , ),
*       - Admin(rank:int)
* <사용자기능> Student
* 1. 회원가입
* 2. 로그인
* 3. 비번 수정
* 4. 회원탈퇴
* 5. 아이디 존재 체크
* 6. 마이페이지
* 7. 점수입력 (자기점수 자기가 입력)
* **********
* <관리자기능> Admin
* 7. 회원목록
* 8. 아이디검색
* 9. 이름검색
* 10. 전체 회원수
* 11. 성적별 현황(스코어 기준 내림차순 ex>1등 이순신(여) 98점, 2등(남) 김유신 85점)
*/
class Menu {
	public static final String MAN_MENU = "메뉴: 0.시스템 종료 1.학생 2.관리자";
	public static final String STUDENT_MENU = " 0. 학생 화면 종료\n 1. 회원가입\n"
			+ " 2. 로그인\n "
			+ " 3. 비번 수정\n"
			+ " 4. 회원탈퇴\n "
			+ " 5. 아이디 존재 체크\n "
			+ " 6. 마이페이지\n "
			+ " 7. 점수입력\n " ;
	public static final String ADMIN_MENU = " 0.관리자 화면 종료\n  1. 회원목록\n" + 
			" 2. 아이디검색\n" + 
			" 3. 이름검색\n" + 
			" 4. 전체 회원수\n" + 
			" 5. 성적별 현황\n" ;
	public static final String PER = "아이디: %s 비번: %s 이름: %s ";
	public static final String STU = "아이디: %s 비번: %ㄴ주민등록번호: %s 점수: %d 성별: %s";	
	public static final String ADM = "관리자 아이디: %s 비번: %s 이름: %s 등급: %d";
}
class Person {
	protected String id, pass, name;
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String toString() {
		return String.format(Menu.PER, id,pass,name) ;
	}
	}
class Student extends Person {
	private String ssn, gender;
    private int score;
    
	public String getSsn() {return ssn;}
	public void setSsn(String ssn) {this.ssn = ssn;}
	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	@Override
	public String toString() {
		return String.format(Menu.PER, ssn, score, gender);
	}	
}
class Admin extends Person {
	private int rank;
	public int getRank() {return rank;}
	public void setRank(int rank) {this.rank = rank;}
	
	public String toString() {
		return String.format(Menu.ADM, id,pass,name,rank);
	}
	}
interface PersonService {
	/** 1. 회원가입 */
	public void join(Student student);
	/**2. 로그인 */
	public String login(Student student);
	/** 3. 비번 수정*/
	public String changePassword(Student student);
	/** 4. 회원탈퇴*/
	public String withdrawl(Student student);
	/** 5. 아이디 검색*/
	public Student searchId(String id);
	/** 6. 마이페이지*/
	public void mypage();
	/** 7. 점수입력*/
	public void score();
	/** 1. 회원목록*/
	public Student[] list();
	/**2. 아이디검색*/ 
	public Student idfind(String id);
	/** 3. 이름검색*/
	public Student[] nameSearch(String name);
	/**4. 전체 회원수*/
	public void count();
	/**5. 성적별 현황*/
	public void gradRank();
}
class PersonServiceImpl implements PersonService {
	private Student[] students;
	private int count;
	
	public PersonServiceImpl() {
		students = new Student[3];
		count = 0;
	}
	@Override /** 1. 회원가입 */
	public void join(Student student) {
		students[count] = student;
		count++;
	}
	@Override /**2. 로그인 */
	//getset해서 받은 아이디와 회원가입시 넣어서 배열에 들어간 아이디와 동일한지 확인
	public String login(Student student) {
		String result = "로그인실패";
		for(int i=0; i <count; i++) {
			if(student.getId().equals(students[i].getId()) 
					&& student.getPass().equals(students[i].getPass())) {
				result = "로그인 성공";
			}
		}
		return result;
	}
	@Override /** 3. 비번 수정*/
	//아이디 확인후 기존 비밀번호에 새로운 비밀번호 넣기
	public String changePassword(Student student) {	
		String result = "수정실패";
		for(int i=0; i<count; i++) {
			if(student.getId().equals(students[i].getId())) {
				students[i].setPass(student.getPass());
				result = "수정완료";
			}
		}
		return result;
	}
	@Override /** 4. 회원탈퇴*/
	//아이디 비번 확인후 탈퇴 count =3
	public String withdrawl(Student student) {
		String result = "탈퇴실패";
		for(int i=0; i < count; i++) {
			if(student.getId().equals(students[i].getId())
					&& student.getPass().equals(students[i].getPass())) {
				students[i] = students[count-1];
				students[count-1] = null;
				count--;
				result = "탈퇴성공";
				break;
			}
		}
		return result;
	}
	@Override /** 5. 아이디 검색*/
	public Student searchId(String id) {
		Student student = new Student();
		for(int i=0; i < count; i++) {
			if(id.equals(students[i].getId())) {
				student = students[i];
				break;
			}
		}
		return student;
	}
	@Override /** 6. 마이페이지*/
	public void mypage() {
		
	}

	@Override/** 7. 점수입력*/
	public void score() {
	}

	@Override	/** 1. 회원목록*/
	public Student[] list() {
		return students;
	}

	@Override/**2. 아이디검색*/ 
	public Student idfind(String id) {
		Student student = new Student();
		for(int i=0; i<count; i++) {
			if(id.equals(students[i].getId())) {
				student = students[i];
				break;
			}
		}
		return student;
	}

	@Override /** 3. 이름검색*/
	public Student[] nameSearch(String name) {
		int cnt=0;
		for(int i=0; i<count; i++) {
			if(name.equals(students[i].getName())) {
				cnt++;
			}
		}
		Student[] result = new Student[cnt];
		int k =0;
		for(int i=0; i<count; i++ ) {
			if(name.equals(students[i].getName())) {
				result[k] = students[i];
				k++;
				if(k == cnt) break;
			}
		}
		return result;
	}

	@Override /**4. 전체 회원수*/
	public void count() {
	}

	@Override 	/**5. 성적별 현황*/
	public void gradRank() {
	}
}
	
public class PersonApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Student student = null;
		PersonService personService = new PersonServiceImpl();
		while(true) {
			System.out.println(Menu.MAN_MENU);
			switch (scanner.nextInt()) {
			case 0: System.out.println("종료");return;
			case 1: student(scanner);break;
			case 2:admin(scanner); break;
			default:
				break;
			}
		}
	}
	public static void admin(Scanner scanner) {
		System.out.println(Menu.ADMIN_MENU);
		switch (scanner.nextInt()) {
		case 0 : System.out.println("종료"); return;
		case 1: 
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default: break;
		}
	}
public static void student(Scanner scanner) {
	System.out.println(Menu.STUDENT_MENU);
	//scanner 생략
	String [] id = {""};
	String [] pass = {""};
	String [] name = {""};
	String [] ssn = {""};
	
	//result = "";
	switch (scanner.nextInt()) {
	case 0 : System.out.println("종료"); return;
	case 1: // 1. 회원가입
		break;
	case 2:// 2. 로그인
		//student = new Student();
		//studet.setId(id[0]);
		break;
	case 3: // 3. 비번수정
		break;
	case 4: // 4. 회원탈퇴
		break;
	case 5: // 5. 아이디 존재 체크
		break;
	case 6: // 6.마이페이지
		break;
	case 7: // 7.
		break;
	default:
		break;
		}
	}
}


