package test0626;

class Vehicle implements Cloneable{
	private String name;
	private int year;
	private String color;
	
	Vehicle() {
		
	}
	Vehicle(int year, String color) {
		this.year = year;
		this.color = color;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void move() {
		
	}
	
	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", year=" + year + ", color=" + color + "]";
	}
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch(CloneNotSupportedException e) {}
		return obj;
	}
}
class Car extends Vehicle{
	String carType;
	
	Car() {
	
	}
	Car(int year, String color, String carType) {
		super(year, color);
		this.carType = carType;
	}

	public String getCarType() {
		return carType;
	}

	public void setCartype(String carType) {
		this.carType = carType;
	}
	
	public void move() {
		System.out.println("Car로 이동");
		
	}
	
	public void refuel() {
		System.out.println("Car에 주유하다");
	}
	
	public boolean equals(Object obj) {
	if(obj != null && obj instanceof Car) {
		return super.getName().equals(((Car)obj).getName());
	}else {
		return false;
	}
}
	@Override
	public String toString() {
		return "Car [carType=" + carType + "]";
	}
	
}

class Autobicycle extends Vehicle{
	private String autoType;
	Autobicycle() {
		
	}
	Autobicycle(int year, String color, String autoType) {
		super(year, color);
		this.autoType = autoType;
	}
	
	
	public String getAutoType() {
		return autoType;
	}
	public void setAutotype(String autoType) {
		this.autoType = autoType;
	}
	public void move() {
		System.out.println("오토바이로 이동");
	}
	
	public void refuel() {
		
	}
	@Override
	public String toString() {
		return "Autobicycle [autoType=" + autoType + "]";
	}
	
	

}
	
public class VehicleTest {
	public static void main(String[] args) {
		Vehicle[] vs = new Vehicle[3];
		vs[0] = new Car(5, "blue", "소나타");
		vs[1] = new Car(5, "blue", "소나타");
		vs[2] = new Autobicycle(6, "rec", "대림");
		vs[0].setName("홍길동");
		vs[1].setName("홍길동");
		vs[0].move(); //Car로 이동
		vs[2].move(); // 오토바이로 이동
		
		System.out.println(vs[0].equals(vs[1])); //재정의해서 값을 비교
		System.out.println(vs[0]); // toString
		
		Vehicle v = (Vehicle)vs[0].clone();
		System.out.println(v.equals(vs[0]));//
		((Car)vs[0]).refuel(); //car로 변환하고 호출
		
	}

}
