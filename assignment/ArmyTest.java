package assignment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

class Army {
	private String name, grade;
	private String strDt, endDt;
	private int age, count;
	private Army[] sub;
	
	
	public Army() {
	}
	public Army(String name,int age, String grade, String strDt, String endDt) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.strDt = strDt;
		this.endDt = endDt;
		this.sub = new Army[5];
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
		case "일병": nightpay= 100000; break;
		case "상병": nightpay= 200000; break;
		case "병장": nightpay= 300000; break;
		}
		return nightpay;
	}
	public void printSubOverTimePay() { //부하별 야근수당을 출력한다
		DecimalFormat df2 = new DecimalFormat("#,###");
		for(Army s : sub) {
			if(s != null && s instanceof SpecialArmy) {
				System.out.printf("{%s}의 야근수당은 {%s}입니다\n",s.getName(),df2.format(s.getOverTimePayByGrade()+((SpecialArmy) s).getBonus()));
			} else if(s!= null) {
				System.out.printf("{%s}의 야근수당은 {%s}입니다\n",s.getName(),df2.format(s.getOverTimePayByGrade()));
			}
		}
	}
	//이달의 마지막날 - 오늘날짜
	public int getThisMMPeriod() { // 이번 달의 남은 근무기간을 리턴한다
		Calendar today = Calendar.getInstance();
		return (today.getActualMaximum(Calendar.DATE)-today.get(Calendar.DATE));
	} 
			
	 public int getSubTotalPeriod() {//부하들의 총 근무기간을 월로 리턴한다
		 Calendar start = Calendar.getInstance();
		 Calendar end = Calendar.getInstance();
		 int totalPeriod = 0;
		
		 for(int i=0; i<count; i++) {
		 int year = Integer.valueOf(sub[i].strDt.substring(0,4));
		 int mm = Integer.valueOf(sub[i].strDt.substring(4,6));
		 int day = Integer.valueOf(sub[i].strDt.substring(6,8));
		 start.set(year, mm, day);
		 
		 year = Integer.valueOf(sub[i].endDt.substring(0,4));
		 mm = Integer.valueOf(sub[i].endDt.substring(4,6));
		 day = Integer.valueOf(sub[i].endDt.substring(6,8));
		 end.set(year, mm, day);
		 
		long cal = (end.getTimeInMillis()-start.getTimeInMillis())/1000;
		 
		totalPeriod += (int)cal/(60*60*24*30);
		 }
		 return totalPeriod;
	 }
	 public void returnSub(Army[] sub) { //부하들 목록을 파리미터 Army[] sub에 리턴한다
		 for(int i=0; i<count; i++) {
		 sub[i] = this.sub[i];
		 }
	 }
	 //병장 홍길동 2019-01-01 ~ 2020-12-31
	 public void printSub() {  //부하들을 출력한다
		 for(int i=0; i<count; i++) {
			 if(sub[i] instanceof SpecialArmy) {
				 System.out.println("우수 "+sub[i].getGrade()+"  "+sub[i].getName()+"  "
				 		+ sub[i].getStrDt().substring(0,4)+ "-" + sub[i].getStrDt().substring(4,6)
				 		+ "-" + sub[i].getStrDt().substring(6,8) + "~" + sub[i].getEndDt().substring(0,4)
				 		+"-" + sub[i].getStrDt().substring(4,6) + "-" + sub[i].getEndDt().substring(6,8));
			 } else {
				 System.out.println(""+sub[i].getGrade()+" "+sub[i].getName()+"  " 
				 		+ sub[i].getStrDt().substring(0, 4)+ "-" + sub[i].getStrDt().substring(4,6)
				 		+ "-" + sub[i].getStrDt().substring(6,8) + "~" + sub[i].getEndDt().substring(0,4)
				 		+ "-" + sub[i].getStrDt().substring(4,6) + "-" + sub[i].getEndDt().substring(6,8));
			 }
		 }
	 }
	 public void addArmySub(Army m) {
		 this.sub[count] = m;
		 count++;
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
		Army sub1 = new Army("이군인", 30, "병장", "20000101", "20100315");
		Army sub2 = new Army("삼군인", 28, "일병", "20000501", "20100315");
		Army sub3 = new SpecialArmy("사군인", 28, "일병", "19990501", "20100315", 100000);
		
		m.addArmySub(sub1);
		m.addArmySub(sub2);
		m.addArmySub(sub3);
		
		
		System.out.println("이번달 남은 근무기간"+m.getThisMMPeriod()+"일 남았습니다"); //남은근무기간
		m.printSub();
		System.out.println("부하들의 근무기간은 총"+m.getSubTotalPeriod()+"개월");

		Army[] sub = new Army[5];
		m.returnSub(sub);
		m.printSubOverTimePay();

		for(int i = 0; i < 3; i++) {
		 System.out.println(sub[i].getName());
		}
		

	}

}
