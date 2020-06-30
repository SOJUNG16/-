package test0630;

public class ProjectTest {
	public static void main(String[] args) {
		Project p = new Project();
		p.setCompany("회사");
		p.setName("이름");
		p.setMonth(13);
		
		Programmer pro = new Programmer();
		pro.addProjectHistory(p);
		pro.printProjectHistory(p);
		pro.getTotalHistory(p);
		
		Project[] parr = new Project[3];
		for(int i = 0; i < 3; i++) {
			parr[i] = new Project();
			parr[i].setCompany("회사"+ (i+1));
			parr[i].setMonth(10);
			parr[i].setName("프로젝트");
		}
		pro.setTotalHistory(parr);
		//parr[1].setCompany("바꿨음");
	}
}
class Programmer {
	private String name;
	private int age;
	private Project now; //현재 진행중인 프로젝트
	private Project[] history; // Project이력
	int count;
	
	
	Programmer() {
		this.history = new Project[3];
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Project getNow() {
		return now;
	}
	public void setNow(Project now) {
		this.now = now;
	}
	public Project[] getHistory() {
		return history;
	}
	public void setHistory(Project[] history) {
		this.history = history;
	}
// Project History는 5개까지 가능: 5개를 넘게 추가 시 메시지
//Project History는 5개까지 추가 가능합니다” //
	public void addProjectHistory(Project p) { //Project 경력을 추가
		if(count<=4) {
			history[count] = p;
			count++;
		} else {
			System.out.println(" Project History는 5개까지 가능");
	}
}
	public void printProjectHistory(Project p) { //Project경력을 출력한다(회사이름/기간)
		for(int i=0; i<count; i++) {
			System.out.println(history[i].toString());
		}
	}
	public void getTotalHistory(Project p) { //모든 Project의 총 경력의 합을 리턴한다(x년x월) month sum
		int sum=0;
		for(int i=0; i<count; i++) {
			sum += p.getMonth();
			System.out.println(sum);
		}
		System.out.printf("%d년 %d월",sum/12, sum%12);
	}
	public void setTotalHistory(Project[] parr) { //총 경력을 설정한다
		//배열은 주소값을 가지고 있음          
		for(int i=0; i<3; i++) {
			
		}
		
		
		
	}
}
class Project {
	private String name;
	private int month;
	private String company; //project 진행중인 회사
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Project [month=" + month + ", company=" + company + "]";
	}
	
	
	
}