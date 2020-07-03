package test0703;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

class Army {
	private String name, grade;
	private String strDt, endDt;
	private int age;
	private Army[] sub;
	
	public Army() {
	}
	public Army(String name,int age, String grade, String strDt, String endDt) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.strDt = strDt;
		this.endDt = endDt;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getStrDt() {
		return strDt;
	}
	public void setStrDt(String strDt) {
		this.strDt = strDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Army[] getSub() {
		return sub;
	}
	public void setSub(Army[] sub) {
		this.sub = sub;
	}
	
	public int getOverTimePayByGrade() { //grade별 야근수당 리턴
		int nightpay=0;
		switch (getGrade()) {
		case "일병": nightpay= 100000;
		case "상병": nightpay= 200000;
		case "병장": nightpay= 300000;
			break;
		}
		return nightpay;
	}
	public void printSubOverTimePay() { //부하별 야근수당을 출력한다
		DecimalFormat df2 = new DecimalFormat("#,###");
		System.out.println("{"+getName()+"}의 야근수당은 {"+df2.format(getOverTimePayByGrade())+"}입니다");
	}
	//이달의 마지막날 - 오늘날짜
	public int getThisMMPeriod() { // 이번 달의 남은 근무기간을 리턴한다
		Calendar today = Calendar.getInstance();
		return (today.getActualMaximum(Calendar.DATE)-today.get(Calendar.DATE));
	} 
			
	 public int getSubTotalPeriod() { //부하들의 총 근무기간을 월로 리턴한다
		 Calendar period = Calendar.getInstance();
		
		 int year = Integer.valueOf(strDt.substring(0,4));
		 int mm = Integer.valueOf(strDt.substring(4,6))-1;
		 int day = Integer.valueOf(strDt.substring(6,8));

		 period.set(year, mm, day);
		 
		 long cal = period.getTimeInMillis()/(1000*60*60*24*30);
		 
		return (int)cal;
		 
	 }
	 public void returnSub(Army[] sub) { //부하들 목록을 파리미터 Army[] sub에 리턴한다
		 
	 }
	 public void printSub() {  //부하들을 출력한다
	 }
	 
	@Override
	public String toString() {
		return "" + grade + "" + name + "" + strDt + "~" + endDt + "";
	}
	 
	 
	
}
class SpecialArmy extends Army{
	private int bonus;  //야근수당에 bonus가 추가된다
	
	public SpecialArmy() {
	}
	public SpecialArmy(String name,int age, String grade, String strDt, String endDt, int bonus) {
		super(name,age,grade,strDt,endDt);
		this.bonus = bonus;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "우수" + super.getGrade() + "" + super.getName() + "" + super.getStrDt() + "~" + super.getEndDt() + "";
	}
	
}
public class ArmyTest {
	public static void main(String[] args) {
		Army m = new Army("김군인", 30, "상병", "20000101", "20100215");
		
		Army[] sub = new Army[5];
		sub[1] = new Army("김군인1", 30, "병장", "20000101", "20100315");
		sub[2] = new Army("김군인2", 28, "일병", "20000501", "20100315");
		sub[3] = new SpecialArmy("김군인3", 28, "일병", "19990501", "20100315", 100000);
		
		m.printSubOverTimePay();
		System.out.println(m.getThisMMPeriod()); //남은근무기간
		m.printSub();
		System.out.println(m.getSubTotalPeriod());

	}

}
