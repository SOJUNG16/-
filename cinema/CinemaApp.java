package cinema;

import java.util.Scanner;

public class CinemaApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CinemaService cinema = new CinemaServiceImpl();
		cinemaMenu(scan, cinema);	// 전체메뉴
	}	// 메인 끝

	public static void cinemaMenu(Scanner scan, CinemaService cinema) {
		while(true) {
			System.out.println("[ 키즈영화관 ]");
			System.out.println("[ 1. 회원메뉴   2. 관리자메뉴   0. 종료  ]");
			int flag = scan.nextInt();
			switch (flag) {
			case 0:	System.out.println("종료합니다.");	return;	
			case 1:	memberMenu(scan, cinema);	break;	// 회원메뉴
			case 2:	adminMenu(scan, cinema);	break;	// 관리자메뉴
			default:	System.out.println("다시 선택해주세요.");	break;
			}
		}
	}
	
	public static void memberMenu(Scanner scan, CinemaService cinema){
		System.out.println("[ 회원메뉴 ]");
		System.out.println("[ 1. 회원가입   2. 로그인   3. 예매하기   4. 마이페이지   5. 이벤트    0. 종료  ]");
		int flag = scan.nextInt();
		switch (flag) {
		case 0:	System.out.println("종료합니다.");	return;	
		case 1:	cinema.join(scan);	break;	// 회원가입
		case 2:	cinema.login();	break;	// 로그인
		case 3: cinema.searchMov(scan);	break;	// 예매하기
		case 4:	cinema.myPage(scan);	break;	// 마이페이지
		case 5:	cinema.addEvent(); break;	// 이벤트
		default:	System.out.println("다시 선택해주세요.");	break;
		}
	}
	
	public static void adminMenu(Scanner scan, CinemaService cinema) {
		System.out.println("[ 관리자메뉴 ]");
		System.out.println("[ 1. 영화등록   2. 상영관설정   3. 회원목록조회   0. 종료  ]");
		int flag = scan.nextInt();
		switch (flag) {
		case 0:	System.out.println("종료합니다.");	return;	
		case 1:	cinema.addMov(scan);	break;	// 영화등록
		case 2:	cinema.setMovRoom(scan);break;	// 상영관설정
		case 3: cinema.memberList(); break;	// 회원목록 조회
		default:	System.out.println("다시 선택해주세요.");	break;
		}
	}
}
