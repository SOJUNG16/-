package test0623;

public class VideoShop2 {
	public static void main(String[] args) {
		Video2 v = new Video2();
		v.setVideoData(100, "물위에서의 하룻밤.", "이승희");
		
		SpecialMember m = new SpecialMember();
		m.setMemberData(1,"허영석", "광진구 123번지", v);
	}
}
class Video2 {
	private int videoNo;
	private String title;
	private String actor;
	
	public void setVideoData(int vno,String t, String a) {
		videoNo =vno;
		title = t;
		actor = a;
	}
	public int getVideoNo() {
		return videoNo;
	}
	public String getTitle() {
		return title;
	}
	public String getActor() {
		return actor;
	}
}
class GeneralMember2{
	private int memberNo;
	private String name;
	private String address;
	private Video2 rentalVideo;
	
	void setMemberData(int mno, String n, String a, Video2 rv) {
		memberNo = mno;
		name = n;
		address = a;
		rentalVideo = rv;
		
	}
	void printMemberData() {
		System.out.println("회원번호:" +memberNo);
		System.out.println("이름:" +name);
		System.out.println("주소:" +address);
		System.out.println("대여중인 비디오 번호:" +rentalVideo.getVideoNo());
		System.out.println("대여중인 비디오 제목:" +rentalVideo.getTitle());
		System.out.println("대여중인 비디오 배우:" +rentalVideo.getActor());
	}
}
class SpecialMember extends GeneralMember2{
	private int bonusPoint;
	
	void setBonusPoint(int b) {
		bonusPoint=b;
	}
	void printBonusPoint() {
		System.out.println("보너스 포인트:" + bonusPoint);
	}
}

