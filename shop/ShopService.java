package shop;

import java.util.Scanner;

public interface ShopService {
	
	public void join (); //아이디 중복체크, 
	public void login ();
	public void changePw ();
	public void myPage(); //아이디,패스워드로 조
	public void searchProd(); //코드로 검색,
	public void addCart(Scanner scan, String prodCode);
	public void pay(Member member);
	public void myCart(Scanner scan);
	public void removeMember(); //아이디, 비밀번호 일치하면 탈퇴
	public void addProd(); //
	public void removeProd(); //코드일치하면 삭제
	public void searchMember(); //아이디로 검색

	
	

}
