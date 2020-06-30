package test0630;

abstract class Animal1{
	String name;
	int age;
	
	public Animal1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public abstract void eat();
	public abstract void sleep();
	public abstract void dong(); //탬플릿
}
class Dog1 extends Animal1{
	String dongType;
	public Dog1(String name, int age, String dongType ) {
		super(name,age);
		this.dongType = dongType;
		}
	@Override
	public void eat() {
		System.out.println("Dog 마구 먹는다");
		
	}
	@Override
	public void sleep() {
		System.out.println("Dog 잘잔다");
		
	}
	@Override
	public void dong() {
		System.out.println("Dog 잘싼다");
		
	}
}
class Cat1 extends Animal1{
	String catType;
	public Cat1(String name, int age, String catType) {
		super(name,age);
		this.catType = catType;
	}
	@Override
	public void eat() {
		System.out.println("Cat 조금 먹는다");
		
	}
	@Override
	public void sleep() {
		System.out.println("Cat 잘 설친다");
		
	}
	@Override
	public void dong() {
		System.out.println("Cat");
		
	}
}
public class AbstractTest {
	

}
