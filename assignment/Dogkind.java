package assignment;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class Dog {
	private String name, kind;
	private int age;
	private ArrayList inoculate;
	private HashSet Handler;
	private HashMap family;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList getInoculate() {
		return inoculate;
	}
	public void setInoculate(ArrayList inoculate) {
		this.inoculate = inoculate;
	}
	public HashSet getHandler() {
		return Handler;
	}
	public void setHandler(HashSet handler) {
		Handler = handler;
	}
	public HashMap getFamily() {
		return family;
	}
	public void setFamily(HashMap family) {
		this.family = family;
	}
	public Dog(String name, int age, String kind) {
	}
	public void shotInoculate(String name, String date) { //예방접종을 하다
		 ArrayList inoculate = new ArrayList();
		 inoculate.addAll(getInoculate());
	}
	 public void printInoculateHistory(ArrayList inoculate) { //예방접종 이력을 날자별 정렬
		 DecimalFormat df2 = new DecimalFormat();
		 Collections.sort(inoculate);
		 
	 }
	 public void addHandler(String name, String strDt, String endDt) { //Handler추가
	 }
	 public int getTotalHandlerPeriod() {
		return age; //Handler의 총 훈련기간
		 
	 }
	 public void addFamily(String info) { //가족추가
		 
	 }
	
}

public class Dogkind {
	public static void main(String[] args) {
		Dog d = new Dog("캐빈", 10, "셰퍼드");
		try {
			d.shotInoculate("장티푸스", "20200707");
			//d.shotInoculate("장티푸스", "20200707");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("예방접종 가능 기간이 아닙니다");
		}
	
		
	}
}
