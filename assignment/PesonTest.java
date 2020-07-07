package assignment;

class Person { //멤버변수: 존재할때 필요한 속성
	private String name;
	private String gender;
	private Hobby b; //클래스
	
	public Person() {
		
	}
	Person(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Hobby getB() {
		return b;
	}
	public void setHobby(Hobby b) {
		this.b = b;
	} 
	
	public void hello() {
		
		
	}
	public void eat() {
		System.out.println("식사를 합니다");
	}
	
}
class Student extends Person{
	Student() {
		
	}
	Student(String name, String gender) {
		super(name, gender);
		
	}
	public void hello() {
		System.out.println("안녕하세요 취미가 "+super.getB().getName()+"인 "+super.getName()+"입니다");
	}
	
}
class Hobby extends Person{
	String name;
	String type;
	
	Hobby() {
		
	}
	Hobby(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

public class PesonTest {
	public static void main(String[] args) {
		Person p = new Student("김학생","남");
		Hobby h = new Hobby("농구", "구기");
		p.setHobby(h);
		p.eat();
		p.hello();
		
	}

}
