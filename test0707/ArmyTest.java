package assignment;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
//•실습: Army에 대한 클래스
//-속성: private String name, private int age, private  String grade
//          , private String strDt, private  String endDt
//          , private Army[] sub
//- 생성자
//  Army(String name, int age, String grade, String strDt, String endDt)
//- 메소드:
//  public int getOverTimePayByGrade(): grade별 야근수당 리턴
//                              일병: 100,000, 상병: 200,000, 병장: 300,000
//  public void printSubOverTimePay(): 부하별 야근수당을 출력한다
//                              형식: ‘{0} 의 야근수당은 {1} 입니다’
//                              금액은 3자리마다 ,를 찍어 표시한다
//  public int getThisMMPeriod(): 이번 달의 남은 근무기간을 리턴한다
//  public int getSubTotalPeriod():부하들의 총 근무기간을 월로 리턴한다
//                                 (월계산은 일차이/30으로 계산한다)
//  public void returnSub(Army[] sub); 부하들 목록을 파리미터 Army[] sub에 리턴한다
//  public void printSub(): 부하들을 출력한다
//                                      병장 홍길동 2019-01-01 ~ 2020-12-31
//                                     우수  상병 김길동 2018-01-01 ~ 2021-05-31
//* SepcialArmy에 대한 클래스
//- 속성: private int bonus   //야근수당에 bonus가 추가된다
//- 생성자: SpecialArmy(String name, int age, String grade
//         , String strDt, String endDt, int bonus)
//- 메서드: get/set Method 
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ArmyTest {
	public static void main(String[] args) {

		Army m = new Army("김군인", 30, "상병", "20000101", "20100215");
		Army sub1 = new Army("김군인1", 30, "병장", "20000101", "20100315");
		Army sub2 = new Army("김군인2", 28, "일병", "20000501", "20100315");
		Army sub3 = new SpecialArmy("김군인3", 28, "일병", "19990501", "20100315", 100000);

	
		m.addArmySub(sub1);
		m.addArmySub(sub2);
		m.addArmySub(sub3);

		m.printSubOverTimePay();
		System.out.println(m.getThisMMPeriod());
		m.printSub();
		System.out.println(m.getSubTotalPeriod());

		Army[] sub = new Army[5];
		m.returnSub(sub);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(sub[i].getName());
		}
	}
}

class Army {
	private String name, grade, strDt, endDt;
	private int age, cnt;
	private Army[] sub;
	Calendar today=Calendar.getInstance();

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

	Army(String name, int age, String grade, String strDt, String endDt) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.strDt = strDt;
		this.endDt = endDt;
	    this.sub = new Army[5];
		
	}

	public int getOverTimePayByGrade() {
		int nightpay=0;

		switch (getGrade()) {
		case "일병":
			nightpay = 100000;
			break;
		case "상병":
			nightpay = 200000;
			break;
		case "병장":
			nightpay = 300000;
			break;
		default:
			System.out.println("grade를 다시 입력하세요.");
			break;
		}
		return nightpay;
	}
	public void printSubOverTimePay() {
		DecimalFormat df2 = new DecimalFormat("#,###");
		System.out.println("{"+getName()+"}의 야근수당은 {"+df2.format(getOverTimePayByGrade())+"}");
		
	}

	public int getThisMMPeriod() {
		return (today.getActualMaximum(Calendar.DATE))-(today.get(Calendar.DATE));
	}

	public int getSubTotalPeriod() {                   //152page해보
		//Date d = new SimpleDateFormat("yyyyMMdd").parse(getStrDt());

		return 0;
	}

	public void returnSub(Army[] sub) {
		//sub = this.sub;
		for(int i = 0; i < cnt; i++) {
			sub[i] = this.sub[i];
		}
	}
	
	public void addArmySub(Army m) {
		this.sub[cnt]=m;
		cnt++;
	}

	public void printSub() {
		for(int i =0; i<cnt; i++) {
			if(sub[i] instanceof SpecialArmy) { //배열이 클래스안에 있으면
				System.out.println("우수 "+sub[i].getGrade()+" "+sub[i].getName()+" "
						+sub[i].getStrDt().substring(0,4)+"-"+sub[i].getStrDt().substring(4,6)+"-"
								+sub[i].getStrDt().substring(6,8)+" ~ "
								+sub[i].getEndDt().substring(0,4)+"-"+sub[i].getEndDt().substring(4,6)
								+"-"+sub[i].getEndDt().substring(6,8));
				} else {
		System.out.println(sub[i].getGrade()+" "+sub[i].getName()+" "
		+sub[i].getStrDt().substring(0,4)+"-"+sub[i].getStrDt().substring(4,6)+"-"
				+sub[i].getStrDt().substring(6,8)+" ~ "
				+sub[i].getEndDt().substring(0,4)+"-"+sub[i].getEndDt().substring(4,6)
				+"-"+sub[i].getEndDt().substring(6,8));
		}
		}
	}

	@Override
	public String toString() {
		return "Army [name=" + name + ", grade=" + grade + ", strDt=" 
	+ strDt + ", endDt=" + endDt + ", age=" + age
				+ ", sub=" + Arrays.toString(sub) + "]";
	}
}

class SpecialArmy extends Army {
	private int bonus;

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	SpecialArmy(String name, int age, String grade, String strDt, String endDt) {
		super(name, age, grade, strDt, endDt);
	}

	SpecialArmy(String name, int age, String grade, String strDt, String endDt, int bonus) {
		super(name, age, grade, strDt, endDt);
		this.bonus = bonus;
	}

}