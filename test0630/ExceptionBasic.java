package test0630;

public class ExceptionBasic {
	public static void main(String[] args) throws Exception{
		//1.JVM이 오류를 인지하여 Exception발생
		Dog[] ds = new Dog[10];
		ds[0].walk();
		
		//2. JVM이 오류를 인지하여 Exception 발생
	    /* Dog[] ds = new Dog[10];
	     * try {
	    	ds[0].work();
	    }catch(Exception e) {
	    	System.out.println(e.getMessage());
	    	e.printStackTrace();
	    }finally {
	    	System.out.println("fianlly 호출");
	    }*/
		//3.Programmer가 Exception을 발생
		Dog d = new Dog("낙동",5);
		 try {
		 d.call(); d.call();
		 if(d.getCallcnt()>1) {
			 throw new Exception("조심");
		 }
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
			 e.printStackTrace();
		 } finally {
			 System.out.println("finally 호출");
		 }
		 //4.함수가 발생시킨 Exception을 잡음
		
		  /*Dog d = new Dog("낙동",5);
		  try{
		  d.eat(); d.eat(); d.eat();
		  } catch(Exception e) {
			  System.out.println(e.getMessage());
			  e.printStackTrace();
		  }finally {
			  System.out.println("finally 호출");
		  */}
		  //5. 받은 Exception을 내가 처리하지 않고 throws처리
		  /*Dog d = new Dog("낙동",5);
		  d.eat(); d.eat(); d.eat();
		  */
	}
}
class Dog2 {
	private String name;
	private int age;
	private int callCnt, eatCnt;
	
	public Dog2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public int getCallcnt() {
		return callCnt;
	}
	public void walk() {
		System.out.println("걷는다");
	}
	public void call() {
		callCnt++;
		System.out.println("멍멍");
	}
	public void eat() throws Exception {
		if(++eatCnt >2) {
			throw new Exception ( "더 먹으면 안돼"); //에러처리하면 
		} System.out.println("먹는다");
	}
}