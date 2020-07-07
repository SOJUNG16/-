package assignment;

//•과제: Animal class를 설계한다
//Animal ani = new Animal();
//ani.setName(“멍뭉이”);
//ani.setAge(5);
//ani.setType(“Dog”); // Type으로는 Dog, Cat이 올수 있다
//ani.bark(5); // 5번 Dog는 ‘멍멍’,Cat은 ‘야옹’으로 출력 5번 멍멍
//ani.toString(); // ‘나는 Dog이고이름은 멍뭉이 입니다’
//Animal.count(); // 동물 수 Count추가
//Animal ani2 = new Animal(ani);
//if(ani2.equals(ani1)){ name와 type기준으로 동일여부 판단
//System.out.println(“같은 강아지 입니다”);}
//Animal.count(); // 동물 수 Count추가
//System.out.println(Animal.totalCount()); // 총 동물수 출력
//equals 재정의//
//
public class AnimalTest{
	
	public static void main(String[] args) {
		Animal ani = new Animal();
		ani.setName("멍뭉이");
		ani.setAge(5);
		ani.setType("Dog");
		System.out.println(ani.toString());
		ani.bark(5);{
		}
		
		
		Animal ani2 = new Animal(ani); //자기자신을 받는 인스턴스
		if(ani==ani2) { //다르다 안에 주소는 다름
			System.out.println("같은 강아지 입니다");
		} else {
			System.out.println("다른 강아지 입니다");
		}
		if(ani.equals(ani2)) { //같다(재정의) 안에 값동일
			System.out.println("같은 강아지 입니다");
		} else {
			System.out.println("다른 강아지 입니다");
		}
		Animal.count(); //static int count -> static은 인스턴스를 사용하지 않아도 클래스에 바로 접근해서 사용가능
		System.out.println(Animal.totalCount());
	}
}

class Animal {
	String name; //멤버변수
	String type;
	int age;
	static int count;
	
	public Animal() { //파라미터 없는 생성자 하나 만들어 놓기 
	}
	
	Animal(Animal ani) { // 이것만 있으면 다음에 Animal ani = new Animal(); 아무것도 없는거 생성 못함
		this.name = ani.name;
		this.type = ani.type;
		this.age= ani.age;
	}
	
	public boolean equals(Object obj) { //obj파라미터
		if(obj != null && obj instanceof Animal) { // obj가 null이 아니고 오브젝트가 애니멀의 인스턴스면 true
			return (this.name == ((Animal) obj).name) 
					&& (this.type == ((Animal) obj).type);
		} else {
		return false;
		}
	}
	//private일때 사용
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	
	public void bark(int a) { //a를 5를 기본으로 줌 return없어서 void
		for(int i = 0; i < a; i++) { //배열인덱스 0 부터 시작 따라서 i<5
		if(type.equals("Dog")) { //type == "Dog" 스트링 비교할때는 사용하면 안됨 스트링은 equals
			System.out.println("멍멍");
		} else if(type.equals("Cat")) {
			System.out.println("야옹");
		}
		}
	}
	@Override
	public String toString() {
		return "'나는" + this.type + " 이고 이름은 " + this.name + "입니다'";
	}
	public static void count() {
		count++;
	}
	public static int totalCount() {
		return count;
	}
	
	}
	




