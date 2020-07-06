package cinema;
import java.util.Scanner;

class Member{
   private String pw, name, bookNum;
   int memberCnt, point;
   Scanner scanner = new Scanner(System.in);
   public Member() {
      
   }
   public Member(String pw, String name) {
      this.pw = pw;
      this.name = name;
   }
   
   public String getBookNum() {
	return bookNum;
}
public void setBookNum(String bookNum) {
	this.bookNum = bookNum;
}
public int getPoint() {return point;}
   public void setPoint(int point) {this.point = point;}
   public String getPw() {return pw;}
   public void setPw(String pw) {this.pw = pw;}
   public String getName() {return name;}
   public void setName(String name) {this.name = name;}
   public int getMemberCnt() {return memberCnt;}
   public void setMemberCnt(int memberCnt) {this.memberCnt = memberCnt;}

   @Override
   public String toString() {
      return "PASSWORD= " + pw + ", NAME=" + name + ", BOOKNUMBER="
            + bookNum + ", POINT=" + point;
   }

}