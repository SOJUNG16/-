package assignment;

import java.util.Calendar;

abstract class Project {
	private String name, locaion;
	private String startDt, endDt;
	private Developer[] dev;
	Project() {
		this.dev = new Developer[3];
	}
	Project(String name, String startDt, String endDt, String location ) {
		this.name = name;
		this.startDt = startDt;
		this.endDt = endDt;
		this.locaion = location;
	}
	Project(String name, String startDt, String endDt, String location, Developer[] dev ) {
		this.name = name;
		this.startDt = startDt;
		this.endDt = endDt;
		this.locaion = location;
		this.dev = dev;
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getStartDt() { return startDt; }
	public void setStartDt(String startDt) { this.startDt = startDt; }
	public String getEndDt() { return endDt; }
	public void setEndDt(String endDt) { this.endDt = endDt; }
	public String getLocaion() { return locaion; }
	public void setLocaion(String locaion) { this.locaion = locaion; }
	public Developer[] getDev() { return dev; }
	public void setDev(Developer[] dev) { this.dev = dev;}
	
	//아래 3개의 함수를 차례로 호출
	public void process() { 
		plan();
		design();
		develop();
	}
	public void plan() {
		System.out.println("프로젝트 준비");
	}
	// Proejct에 개발자 Add
	public void join(Developer d) {
		int count = 0;
		dev[count] = d;
		count++;
	}
	public abstract void design();
	public abstract void develop();
	
	 public int getPeriod() { //startDt와 endDt의 날자차이를 리턴,  getTimeInMillis()이용
		 Calendar start = Calendar.getInstance();
		 Calendar end = Calendar.getInstance();
		 //이상 미만
		 int year = Integer.valueOf(startDt.substring(0,4));
		 int month = Integer.valueOf(startDt.substring(4,6))-1;
		 int day = Integer.valueOf(startDt.substring(6,8));
		
		 start.set(year,month,day);
		
		 year = Integer.valueOf(endDt.substring(0,4));
		 month = Integer.valueOf(endDt.substring(4,6))-1;
		 day = Integer.valueOf(endDt.substring(6,8));
		 //일차이계산 (end - start)
		 end.set(year, month, day);
		 
		long cal = (end.getTimeInMillis() - start.getTimeInMillis())/(1000*60*60*24);
		return (int)cal;
	
 	}
	public int getMMByDeveloper(Developer [] dev) { //Project에 참여한 개발자의 총 월간 개월수
		int sum = 0; 
		for(int i=0; i<dev.length; i++) {
			 sum += dev[i].getPeriod();
		 }
		return sum;
	}
	 public void printDeveloper(Developer [] dev) { //고급개발자인 경우 ‘고급개발자’로 출력하고 특기표시
		 for(int i=0; i<dev.length; i++) {
		 System.out.println(dev[i].toString());
		 }
	 }
}
class HrProject extends Project {
	HrProject() {
	}
	HrProject(String name, String startDt, String endDt, String location) {
		super(name,startDt,endDt,location);
	}
	@Override
	public void design() {
		System.out.println("HR 설계작업수행");
	}
	@Override
	public void develop() {
		System.out.println("HR 개발작업수행");
	}
}
class Developer {
	private String name;
	private int period;
	
	public Developer() {
	}
	public Developer(String name, int period) {
		this.name = name;
		this.period = period;
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getPeriod() { return period; }
	public void setPeriod(int period) { this.period = period;}
	@Override
	public String toString() {
		return "일반개발자 " + getName() + "";
	}
}
class HighDeveloper extends Developer {
	private String specialSkil;
	
	HighDeveloper() {
	}
	
	public HighDeveloper(String name, int period, String specialSkil) {
		super(name, period);
		this.specialSkil = specialSkil;
	}
	public String getSpecialSkil() { return specialSkil; }
	public void setSpecialSkil(String specialSkil) { this.specialSkil = specialSkil; }

	@Override
	public String toString() {
		return "고급개발자 "+super.getName()+"/특기 "+ getSpecialSkil() +"";
	}
}
public class DeveloperTest {
	public static void main(String[] args) {
		Developer [] dev = new Developer[3];
		dev[0] = new Developer("홍길동", 10);
		dev[1] = new Developer("김길동", 28);
		dev[2] = new HighDeveloper("김고급",50,"Java");
		
		Project p = new HrProject("홍길동", "20200601", "20200620", "서울");
		p.printDeveloper(dev);
		System.out.println(p.getMMByDeveloper(dev));
		p.design();
		p.develop();
		System.out.println(p.getPeriod());
		
		
		
	}

}
