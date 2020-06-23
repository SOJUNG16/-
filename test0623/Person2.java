package test0623;

class Person2 {
	long id;
	public boolean equals(Object obj) {
		if(obj !=null && obj instanceof Person2) {
			return id == ((Person2)obj).id; //obj가 Person2의 인스턴스
		} else {
			return false;
		}
	}
	Person2(long id) {
		this.id = id;
	}
}

class EqualsEx2 {
	public static void main(String[] args) {
		Person2 p1 = new Person2(8011081111222L);
		Person2 p2 = new Person2(8011081111222L);
		
		if(p1==p2) {
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
		if(p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
	}
}