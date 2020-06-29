package shop;

import java.util.Scanner;

public class ShopApp {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ShopServiceImpl shop = new ShopServiceImpl();
		
		while (true) {
			System.out.println("[0.나가기 1.회원메뉴 2.관리자메뉴]");
			switch (scan.nextInt()) {
			case 0:
				System.out.println("<시스템 종료>");
				return;
			case 1:
				memberMenu(scan, shop);	// 회원메뉴
				break;
			case 2:
				adminMenu(scan, shop);	// 관리자메뉴	
				break;
			}
		}
	}

	public static void memberMenu(Scanner scan, ShopServiceImpl shop) {
		while (true) {
			System.out.println("<회원메뉴>");
			System.out.println("[0.나가기 1.회원가입 2.로그인 3.비밀번호변경 4.마이페이지 5.상품조회 6.장바구니 7.회원탈퇴]");
			switch (scan.nextInt()) {
			case 0:
				return;
			case 1: 
				shop.join();	// 회원가입
				break;
			case 2:
				shop.login();	// 로그인
				break;
			case 3:
				shop.changePw();	// 비번변경
				break;
			case 4:
				shop.myPage();	// 마이페이지
				break;
			case 5:
				shop.searchProd();	// 상품조회
				break;
			case 6:
				shop.myCart(scan);	// 장바구니
				break;
			case 7:
				shop.removeMember(); // 회원탈퇴
				break;
			default:
				System.out.println("잘못된 입력");
				break;
			}
		}
	}
	
	public static void adminMenu(Scanner scan, ShopServiceImpl shop) {
		while (true) {
			System.out.println("<관리자메뉴>");
			System.out.println("[0.나가기 1.상품등록 2.상품삭제 3.회원정보조회]");
			switch(scan.nextInt()) {
			case 0:
				return;
			case 1: 
				shop.addProd();	// 상품등록
				break;
			case 2:
				shop.removeProd();	// 상품삭제
				break;
			case 3:
				shop.searchMember();	// 회원정보조회
				break;
			default:
				System.out.println("잘못된 입력");
				break;
			}
		}
	}
}