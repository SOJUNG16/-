package test0622;

interface EmployeeType {
	public int getAmount();
}

class Engimeer implements EmployeeType{
	public int getAmount() {
		return 100;
	}
}

class Manager implements EmployeeType{
	public int getAmount() {
		return 200;
	}
}

class Salesman implements EmployeeType {
	public int getAmount() {
		return 300;
	}
}
class Employee2{
	private EmployeeType type;
	
	public Employee2(EmployeeType type) {
		setType(type);
	}
	public void setType(EmployeeType type) {
		this.type=type;
	}
	public int getAmount() {
		return type.getAmount();
	}
	
	public static void main(String[] args) {
		
	}
}