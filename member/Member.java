package member;

//한사람의 정보 입력함 자리가 한개. 따라서 새정보 입력하면 기존의 정보 사라짐
public class Member {
	private String userid, password, name; 
	
	public Member() {
		
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserid() {
		return this.userid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public String toString() {
		return "[아이디: "+userid+", 비번: "+password+", 이름: "+name+"]"; //this.userid this 생략가능
	}
}
