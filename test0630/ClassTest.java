package test0630;

class Parent {
	String name;
	int age;
	Hobby hobby;
	
	public Parent() {
	}
	public Parent(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Hobby getHobby() {
		return hobby;
	}
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
}
class Child extends Parent {
	public Child() {
	}
	public Child(String name) {
		super(name);
	}
	
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Child) {
			return super.getName().equals(((Child)obj).getName());
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return hobby.toString();
	}
	
}
class Hobby {
	
}
class Piano extends Hobby{
	@Override
	public String toString() {
		return "피아노";
	}
}
class Tennis extends Hobby{
	@Override
	public String toString() {
		return "테니스";
	}
	}

public class ClassTest {
	public static void main(String[] args) {
		Child c = new Child("홍길동");
		Parent p = c;
		//Parent p = new Child();
		c.setAge(30);
		
		Tennis t = new Tennis();
		Hobby b = t;
		c.setHobby(t);
		
		Piano p2 = new Piano();
		Hobby b2 = p2;
		c.setHobby(p2);
		
		Child c2 = new Child("홍길동");
		System.out.println(c); //피아노
//		c.setHobby(t);
//		System.out.println(c); //테니스
		System.out.println(c.equals(c2));//true
	}

}
