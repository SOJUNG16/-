package test0631;

class Mother {
	private String name;
	private int age;
	private String job;
	private Child[] childs; //
	
	Mother() {
	}
	Mother(String name, int age) {
		this.name = name;
		this.age = age;
	}
	Mother(String name, int age, Child[] childs) {
		this(name, age);
		this.childs = new Child[3];
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Child[] getChilds() {
		return childs;
	}
	public void setChild(Child[] c) {
		this.childs = c;
	}
	
	void goToSchool() { //‘아이들과학교가다’ 출력
		System.out.println("아이들과 학교가다");
	}
	void callChild(Child[] c) { // 아이들 수만큼 출력 => ‘아이이름’이 지금 갑니다
		for(int i=0; i<3; i++) {
			System.out.println(""+c[i].getName()+"이 지금 갑니다");
		}
	}
}
class Child{
	String name;
	int age;
	String [] hobby;
	
	Child() {
	}
	Child(String name, int age) {
		this.name = name;
		this.age = age;
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
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) { //‘바둑,농구,수영’을 전달하면String[] hobby에 추가되도록 구현
		//this.hobby = hobby;
		String [] arr = hobby.split(",");
			this.hobby = arr;
//		for(int i =0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
	}
	void goToSchool() {
		System.out.println("학교가다");
	}
	void fight(Child c) { //‘아이이름’과 싸웠습니다 출력 전부다 출력하고 싶은게 아니라 하나만 출력해야 하니까 c를 받음
		System.out.println(""+c.getName()+"과 싸웠습니다");
	}
}
public class MotherTest {
	public static void main(String[] args) {
		
		Child[] c = new Child[3];
		String [] hobby = {"바둑","농구","수영"};
		for(int i = 0; i < 3; i++) {
			c[i] = new Child();
			c[i].setName("아이이름"+ (i+1));
			c[i].setAge(10);
			c[i].setHobby("바둑,농구,수영");
		}
		
		Mother m = new Mother();
		m.goToSchool();
		m.callChild(c);
		
		Child c2 = new Child();
		c2.goToSchool();
		c2.fight(c[1]);
		c2.setName(hobby[1]);
		System.out.println(hobby[1]);
		
	}

}
