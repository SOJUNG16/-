package assignment;

//실습: 다음 클래스 설계
//SpecialMember, Member를 설계하시오
//1. Member
//   - 속성:name, grade
//   - 메소드:get/set, hello()
//2. SpecialMember: name, grade, specialPoint
//- 속성: name, grade, specialPoint
//- 메소드: get/set,hello()
//Member m = new Member(“김길동”);
//m.setGrade(“3”);
//m.hello(); //  안녕하세요 김길동입니다
//SpecialMember sm= new SpecialMember(“홍길동”);
//sm.setGrade(“1”);
//sm.setSpecialPoint(100); // SpecialMember만 specialPoint관리
//Member m2 = sm;
//m2.hello(); // 안녕하세요스패설멤버 홍길동입니다

class Member{
	String name;
	String grade;
	
	public Member() {
	}
	
	Member(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void hello() {
		System.out.println("안녕하세요 "+this.name+" 입니다");
	}
}
class SpecialMember extends Member{
	int specialPoint;
	
	SpecialMember() {
		
	}
	SpecialMember(String name) {
		super(name);
	}

	public int getSpecialPoint() {
		return specialPoint;
	}

	public void setSpecialPoint(int specialPoint) {
		this.specialPoint = specialPoint;
	}
	public void hello() {
		System.out.println("안녕하세요 SpecialMember "+this.name+" 입니다");
	}
}
public class MemberTest {
	public static void main(String[] args) {
		Member m = new Member("김길동");
		m.setGrade("3");
		m.hello();
		
		SpecialMember sm = new SpecialMember("홍길동");
		sm.setGrade("1");
		sm.setSpecialPoint(100);
		sm.hello();
	}

}
