package test0630;

public class PetOwner {
	public static void main(String[] args) {
		Vet v = new Vet();
		Dog d = new Dog();
		Cat c = new Cat();
		v.giveShot(d);
		v.giveShot(c);
	}
}
class Vet {
	public void giveShot(Animal a) {
		a.makeNoise();
	}
}
class Animal {
	public void makeNoise() {
	}
}
class Dog extends Animal {
	public void makeNoise() {
		System.out.println("멍멍");
	}
}
class Cat extends Animal {
	public void makeNoise() {
		System.out.println("야옹");
	}
}