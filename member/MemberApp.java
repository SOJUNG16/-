package member;

//* 요구사항 (기능정의)

//* <사용자기능>
//* 1. 회원가입
//* 2. 로그인
//* 3. 비번 수정
//* 4. 회원탈퇴
//* 5. 아이디 존재 체크
//* 6. 마이페이지
//* **********
//* <관리자기능>
//* 7. 회원목록
//* 8. 아이디검색
//* 9. 이름검색
//* 10. 전체 회원수
//*

import java.util.Scanner;

public class MemberApp {
	public static void main(String[] args) { //static open 공간
		Scanner scanner = new Scanner(System.in);
		Member member = null; //주소가 없는 상태 이전 주소 초기화
		MemberService memberService = new MemberServiceImpl(); //회원가입 정보 MemberServiceImpl 에 입력해주고 사라짐
		while(true) {
			System.out.println("메뉴: 0.종료 1.회원가입 2.로그인 3.회원목록 "
					+ "4.아이디 중복체크 5. 비번수정 6.회원탈퇴 7.아이디 검색"
					+ " 8.이름검색  9.전체 회원수");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("종료"); return;
			case 1 :  //회원가입
				member = new Member(); // new 주소
				System.out.println("회원가입");
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("비밀번호: ");
				member.setPassword(scanner.next());
				System.out.println("이름: ");
				member.setName(scanner.next());
				memberService.join(member);
				break;
			case 2 : //로그인
				System.out.println("로그인");
				member = new Member();
				System.out.println("아이디");
				member.setUserid(scanner.next());
				System.out.println("비밀번호");
				member.setPassword(scanner.next());
				String result = memberService.login(member);
				System.out.println(result);
				break;
			case 3 : //회원목록
				System.out.println("목록보기");
				Member[] list = memberService.list();
				for(int i=0; i < list.length; i++) {
					if(list[i]!=null) {
						System.out.println(list[i].toString());
					} else {
						System.out.println("정보가 없습니다.");
					}
				}
					break;
			case 4 : //아이디중복체크
				System.out.println("아이디 체크");
				member = new Member();
				System.out.println("아이디: ");
				result = memberService.existId(scanner.next());
				System.out.println(result);
				break;
			case 5 : //비번수정
				System.out.println("비밀번호 수정");
				member = new Member();
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("변경할 비밀번호: "); //아이디는 같고 비밀번호는 다름
				member.setPassword(scanner.next());
				result = memberService.changePassword(member);
				System.out.println(result);
				break;
			case 6 : //회원탈퇴
				System.out.println("회원탈퇴");
				member = new Member();
				System.out.println("삭제할 아이디: ");
				member.setUserid(scanner.next());
				System.out.println("비번 다시 입력: ");
				member.setPassword(scanner.next());
				result = memberService.withdrawal(member);
				System.out.println(result);
				break;
			case 7 : //아이디 검색
				System.out.println("아이디 검색");
				member = new Member();
				member = memberService.idSearch(scanner.next());
				System.out.println(member.toString());
				break;
			case 8 : //이름 검색
				System.out.println("이름검색");
				Member[] findMembers = memberService.nameSearch(scanner.next());
				for(Member m: findMembers) {
					System.out.println(m.toString());
				}
				break;
			case 9 : //전체 회원수
				System.out.println(memberService.count());
				break;
			default: 
				System.out.println("메뉴에 없는 기능입니다"); 
			break;	
			}
		}
	}
}
	