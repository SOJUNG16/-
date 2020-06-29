package oop;

import java.util.Scanner;

/*
 * RFP
 * Person(id, pass, name:String) 
 *       - Student(ssn:String, score:int), 
 *       - Admin(rank:int)
 * <사용자기능> Student
 * 1. 회원가입
 * 2. 로그인 
 * 3. 비번 수정
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * 6. 마이페이지
 * 7. 점수 입력
 * **********
 * <관리자기능> Admin
 * 1. 회원목록
 * 2. 아이디검색
 * 3. 이름검색
 * 4. 전체 회원수
 * 5. 성적별 현황 (스코어 기준 이름 내림차순 예.. 1등 이순신(여) 98점, 2등 김유신(남) 85점... )
 */
class Constants{
	public static final String MAN_MENU = "0.시스템종료 1.학생 2.관리자";
	public static final String STUDENT_MENU = "\n0.학생화면 종료 \n"+ 
			" 1. 회원가입\n" + 
			" 2. 로그인 \n" + 
			" 3. 비번 수정\n" + 
			" 4. 회원탈퇴\n" + 
			" 5. 아이디 존재 체크\n" + 
			" 6. 마이페이지\n" + 
			" 7. 점수 입력\n";
	public static final String ADMIN_MENU = "\n0.관리자화면 종료\n "+
			"1. 회원목록\n" + 
			"2. 아이디검색\n" + 
			"3. 이름검색\n" + 
			"4. 전체 회원수\n" + 
			"5. 성적별 현황\n";
	public static final String PERSON_SPEC = "아이디: %s 비번: %s 이름: %s";
	public static final String STUDENT_SPEC = "아이디: %s 비번: %s 이름: %s(%s) 주민번호: %s 점수: %d";
	public static final String ADMIN_SPEC = "관리자 아이디: %s 비번: %s 이름: %s 등급: %d";
}
class Person{
	protected String id, pass, name;

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	@Override public String toString() {
		return String.format(Constants.PERSON_SPEC, id, pass, name);
	}
}
class Student extends Person{
	private String ssn, gender;private int score;
	
	public String getSsn() {return ssn;}
	public void setSsn(String ssn) {this.ssn = ssn;}
	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	@Override public String toString() {
		return String.format(Constants.STUDENT_SPEC, id, pass, name, gender, ssn, score);
	}
}
class Admin extends Person{
	private int rank;

	public int getRank() {return rank;}
	public void setRank(int rank) {this.rank = rank;}
	@Override public String toString() {
		return String.format(Constants.ADMIN_SPEC, id, pass, name, rank);
	}
}
interface PersonService{
	/** 1. 회원가입  */
	public void join(Student student);
	/** 2. 로그인  */  
	public String login(Student student);
	/** 3. 비번 수정  */
	public void changePass(Student student);
	/** 4. 회원탈퇴  */
	public void remove(Student student);
	/** 5. 아이디 존재 체크 */ 
	public String existId(String id);     
	
	
	
	
	public Student mypage(String id);
	/** 7. 점수 입력 */
	public void score(int[] arr);
	/** 8. 회원목록 */ 
	public Student[] studentList();
	/** 9. 아이디검색 */ 
	public Student idSearch(String id);
	/** 10. 이름검색  */
	public Student[] nameSearch(String name);
	/** 11. 전체 회원수 */ 
	public int studentCount();
	/** 12. 성적별 현황 */
	public Student[] gradeRank();
}
class PersonServiceImpl implements PersonService {
	private Student[] students;
	private int count;
	
	public PersonServiceImpl() {
		students = new Student[4]; 
		count = 0;
	}

	@Override
	public void join(Student student) {
		/** 1. 회원가입  */
		String gender = student.getSsn();
		String result = "";
		switch(gender.charAt(7)) { // 900505-1 이면 1의 인덱스는 7
			case '1': case '3': result = "남"; break;
			case '2': case '4': result = "여"; break;
			default : result ="오류";
		}
		student.setGender(result);
		students[count] = student;
		count++;
	}

	@Override
	public String login(Student student) {
		/** 2. 로그인  */ 
		String result = "로그인 실패";
		for(int i= 0; i < count; i++) {
			if(student.getId().equals(students[i].getId())
					&& 
			   student.getPass().equals(students[i].getPass())) {
				result = "로그인 성공";
				break;
			}
		}
		return result;
		
	}

	@Override
	public void changePass(Student student) {
		/** 3. 비번 수정  */
		for(int i= 0; i < count; i++) {
			if(student.getId().equals(students[i].getId())) {
				students[i].setPass(student.getPass());
				break;
			}
		}
	}

	@Override
	public void remove(Student student) {
		/** 4. 회원탈퇴  */
		for(int i= 0; i < count; i++) {
			if(student.getId().equals(students[i].getId())
					&& 
			   student.getPass().equals(students[i].getPass())) {
				students[i] = students[count - 1];
				students[count - 1]= null;
				count --;		
				break;
			}
		}
	}

	@Override
	public String existId(String id) {
		/** 5. 아이디 존재 체크 */ 
		String result = "사용 가능한 아이디";
		for(int i= 0; i < count; i++) {
			if(id.equals(students[i].getId())) {
				result ="이미 존재하는 아이디";
				break;
			}
		}
		return result;
	}

	@Override
	public Student mypage(String id) {
		/** 6. 마이페이지 */ 
		Student student = new Student();
		for(int i= 0; i < count; i++) {
			if(id.equals(students[i].getId())) {
				student = students[i];
				break;
			}
		}
		return student;
	}

	@Override
	public void score(int[] arr) {
		/** 7. 점수 입력 */
		for(int i=0; i< count; i++) {
			students[i].setScore(arr[i]);
		}
	}

	@Override
	public Student[] studentList() {
		/** 8. 회원목록 */ 
		return students;
	}

	@Override
	public Student idSearch(String id) {
		Student student = new Student();
		/** 9. 아이디검색 */ 
		for(int i= 0; i < count; i++) {
			if(id.equals(students[i].getId())) {
				student = students[i];
				break;
			}
		}
		return student;
	}

	@Override
	public Student[] nameSearch(String name) {
		/** 10. 이름검색  */
		int cnt = 0;
		for(int i= 0; i < count; i++) {
			if(name.equals(students[i].getName())) {
				cnt++;	
			}
		}
		Student[] sameNames = new Student[cnt];
		int k =0;
		for(int i= 0; i < count; i++) {
			if(name.equals(students[i].getName())) {
				sameNames[k] = students[i];
				k++;
				if(cnt == k) break;
			}
		}
		return sameNames;
	}

	@Override
	public int studentCount() {
		/** 11. 전체 회원수 */ 
		return count;
	}

	@Override
	public Student[] gradeRank() {
		/** 12. 성적별 현황 */
		for(int i=0; i< count; i++) {
			for(int j= 0; j < i; j++) {
				if(students[i].getScore() > students[j].getScore()) {
					Student t = students[i];
					students[i] = students[j];
					students[j] = t;
				}
			}
		}
		return students;
	}
}
public class PersonApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PersonService service = new PersonServiceImpl();
		Student student = null;
		Admin admin = null;
		while(true) {
			System.out.println(Constants.MAN_MENU);
			switch(scanner.nextInt()) {
			case 0: return;
			case 1: student(scanner, student, service); break;
			case 2: admin(scanner, admin, service); break;
			default: System.out.println("1. 학생 2. 관리자 선택바랍니다.");break;
			
			}
		}
	}
	public static void student(Scanner scanner, Student student, PersonService service) {
		System.out.println(Constants.STUDENT_MENU);
		// scanner 입력 생략
		String[] id = {"kim","you","lee","lee"};
		String[] name = {"김유신","유관순","이순신","이순신"};
		String[] ssn = {"900101-1","900501-2","900801-1","901201-2"};
		String result ="";
		switch (scanner.nextInt()) {
		case 0:return;
		case 1: /** 1. 회원가입  */
			for(int i=0; i < id.length; i ++) {
				student = new Student();
				student.setId(id[i]);
				student.setPass("1");
				student.setName(name[i]);
				student.setSsn(ssn[i]);
				service.join(student);
			}
			break;
		case 2: /** 2. 로그인  */ 
			student = new Student();
			student.setId(id[0]);
			student.setPass("1");
			result = service.login(student); 
			System.out.println(result);
			break;
		case 3: /** 3. 비번 수정  */
			student = new Student();
			student.setId(id[2]);
			student.setPass("2");
			service.changePass(student); 
			break;
		case 4: /** 4. 회원탈퇴  */
			student.setId(id[0]);
			student.setPass("1");
			service.remove(student); break;
		case 5: /** 5. 아이디 존재 체크 */ 
			System.out.println(service.existId("kim")); break;
		case 6: /** 6. 마이페이지 */ 
			System.out.println(service.mypage("kim")); break;
		case 7: /** 7. 점수 입력 */
			int[] scores = {70, 60, 80, 30};
			service.score(scores); 
			break;
		default:
			break;
		}
	}

	public static void admin(Scanner scanner, Admin admin, PersonService service) {
		System.out.println(Constants.ADMIN_MENU);
		switch (scanner.nextInt()) {
		case 0:return;
		case 1: 
			Student[] list = service.studentList();
			for(Student s : list) {
				System.out.println(s.toString());
			}
		break;
		case 2: System.out.println(service.idSearch("kim").toString()); break;
		case 3: 
			Student[] sameNames = service.nameSearch("이순신");
			for(Student s : sameNames) {
				System.out.println(s.toString());
			}
			break;
		case 4: 
			System.out.printf("총 %d 명",service.studentCount()); break;
		case 5: 
			Student[] ranks = service.gradeRank(); 
			for(Student s : ranks) {
				System.out.println(s.toString());
			}
			break;
		default:
			break;
		}
	}

	
}






