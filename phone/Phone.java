package phone;

import java.util.Scanner;
/**
  @author SOJUNG
  @since 2020.06.18
  @param kind 폰종류, company 제조사, call 통화내역
 */
class BelPhone {
	protected String kind, company, call;

	public String getKind() {return kind;}
	public void setKind(String kind) {this.kind = kind;}
	public String getCompany() {return company;}
	public void setCompany(String company) {this.company = company;}
	public String getCall() {return call;}
	public void setCall(String call) {this.call = call;}
	@Override
	public String toString() {
		return "집전화 [폰종류=" + kind + ", 제조사=" + company + ", 통화내역=" + call + "]";
	}
}
class CelPhone extends BelPhone{
	public final static String KIND = "휴대폰";
	protected boolean portable;
	protected String move;
	
	//버튼처럼 만들어주기 위해 ture= 이동가능 false=이동불가능
	public boolean isPortable() {return portable;} //boolean상태 getter
	public void setPortable(boolean portable) {
//		if(portable) {
//			this.move = "이동가능";
//		} else {move =  "이동불가능";}
		move = (portable) ? "이동중" : "이동불가능" ;
		this.portable = portable;
	}

	public String getMove() {return move;}
	public void setMove(String move) {this.move = move;}
	@Override
	public String toString() {
		return String.format("%s인 %s 제품을 사용해서 %s 라고 %s 통화한다", 
				KIND, company ,call, move); //생략가능
}
}
class Iphone extends CelPhone {
	public final static String KIND = "아이폰";
	protected String search;
	public String getSearch() {return search;}
	public void setSearch(String search) {this.search = search;}
	public String toString() {
		return String.format("%s %s을 사용해서 %s에 %s한다", 
				super.getCompany(), KIND , super.move, this.search );
	}
}
class GalPhone extends Iphone{
	public final static String KIND = "갤럭시";
	protected String pay;
	public String getPay() {return pay;}
	public void setPay(String pay) {this.pay = pay;}
	public String toString() {
		return String.format("%s %s를 사용해서 %s에 %s한다.", 
				company, KIND, move, pay);
	}
	//[삼성] 갤럭시 제품을 사용해서 [이동중]에 [삼성페이결제]한다.
}
//extends Object
public class Phone {
	public static void main(String[] args) {
		//copy
		Scanner scanner = new Scanner(System.in);
		BelPhone phone = null;
		BelPhone[] arr = new BelPhone[1]; //부모에 선언된 배열에는 자식들이 다 들어갈 수 있음
		CelPhone cel = null;
		Iphone iphone = null; //디스크에 존재
		GalPhone gal =null;
		GalPhone [] arr2 =new GalPhone[1];
		while(true) {
			System.out.println("0.종료 1.집전화걸기 2.전화받기 3. 휴대폰 걸기 "
					+ "4.아이폰 서치 5.삼성페이결제");
			switch(scanner.nextInt()) {
			case 0 : return;
			case 1 : // 전화걸기
				phone = new BelPhone(); //지워짐
				phone.setKind("집전화");
				phone.setCompany("금성사");
				phone.setCall("안녕하세요");
				arr[0] = phone;
				break;
			case 2 : //전화받기
				System.out.println(arr[0].toString()); break;
			case 3 : //휴대폰 전화걸기
				cel= new CelPhone();
				cel.setCompany("노키아");
				cel.setPortable(true);
				cel.setCall(" 통화하고 있다.");
				arr[0] = cel;
				break;
			case 4 : //아이폰 검색
				iphone = new Iphone(); //메모리에 올라옴
				iphone.setCompany("애플");
				iphone.setPortable(true);
				iphone.setSearch("뉴스검색");
				arr2[0] = (GalPhone) iphone; //캐스팅
				break;
			case 5:
				gal = new GalPhone();
				gal.setCompany("삼성");
				gal.setPortable(true);
				gal.setPay("삼성페이결제");
				arr[0] = gal;
				break;
			default:
				break;
			}
			}
		}
		
	}
