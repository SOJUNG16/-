package oop;
/**
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 로그인 
 * 3. 비번 수정
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * 6. 마이페이지
 * **********
 * <관리자기능>
 * 7. 회원목록
 * 8. 아이디검색
 * 9. 이름검색
 * 10. 전체 회원수
 */

import java.util.Scanner;

class Member {
	private String userid,password, name;
	
	public Member() {
		// TODO Auto-generated constructor stub
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
		return "[아이디: "+userid+", 비번: "+password+", 이름: "+name+"]";
	}

}
interface MemberService {
	// 1. 회원가입
	public void join(Member member);
	// 2. 로그인
	public String login(Member member);
	// 3. 회원목록
	public Member[] list();
	// 4. 아이디 중복체크
	public String existId(String id);
	// 5. 비번 수정
	public String changePassword(Member member);
	// 6. 회원탈퇴
	public String withdrawal (Member member);
	// 7. 아이디검색
	public Member idSearch(String id);
	// 8. 이름 검색
	public Member[] nameSearch(String name);
	// 9. 전체 회원수
	public int count();
}
class MemberServiceImpl implements MemberService{
	private Member[] members; 
	private int count;
	
	public MemberServiceImpl() {
		members  = new Member[3];
		count = 0;
	}
	// 1. 회원가입
	@Override
	public void join(Member member) {
		members[count] = member;
		count++;
	}
	
	// 2. 로그인
	@Override
	public String login(Member member) {
		String result = "FAIL";
		for(int i=0;i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
				member.getPassword().equals(members[i].getPassword())) {
				result = "SUCCESS";
				break;
			}
		}
		return result;
	}
	// 3. 회원목록
	@Override
	public Member[] list() {
		return members;
	}
	// 4. 아이디 중복체크
	@Override
	public String existId(String id) {
		String result = "중복없음";
		for(int i=0; i< count; i++) {
			if(id.equals(members[i].getUserid())) {
				result ="중복된 아이디";
			}
		}
		return result;
	}
	// 5. 비번 수정
	@Override
	public String changePassword(Member member) {
		String result = "수정실패";
		for(int i =0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				members[i].setPassword(member.getPassword());
				result = "수정성공";
				break;
			}
		}
		return result;
	}
	// 6. 회원탈퇴
	@Override
	public String withdrawal(Member member) {
		String result = "탈퇴 실패";
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&& member.getPassword().equals(members[i].getPassword())) {
				members[i] = members[count-1];
				members[count-1] = null;
				count --;
				result = "탈퇴 성공";
				break;
			}
		}
		return result;
	}
	// 7. 아이디검색
	@Override
	public Member idSearch(String id) {
		Member member = new  Member();
		for(int i =0; i< members.length; i++) {
			if(id.equals(members[i].getUserid())) {
				member = members[i];
				break;
			}
		}
		return member;
	}
	// 8. 이름 검색(동명이인 처리필요)
	@Override
	public Member[] nameSearch(String name) {
		int cnt = 0; // 동명이인의 수
		for(int i =0; i< members.length; i++) {
			if(name.equals(members[i].getName())) {
				cnt++;
			}
		}
		Member[] searchMembers = new Member[cnt];
		int k = 0;
		for(int i =0; i< members.length; i++) {
			if(name.equals(members[i].getName())) {
				searchMembers[k] = members[i];
				k++;
				if(k == cnt) break;
			}
		}
		return searchMembers;
	}
	// 9. 전체 회원수
	@Override
	public int count() {
		return count;
	}
}
public class MemberApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Member member = null;
		MemberService memberService = new MemberServiceImpl();
		while (true) {
			System.out.println("메뉴: 0.종료 1.회원가입 2.로그인 "
					+ "5.아이디존재 7.아이디검색 8. 이름검색");
			switch (scanner.nextInt()) {
			case 0: System.out.println("종료");return;
			case 1: // 1. 회원가입
				member = new Member();
				System.out.println("회원가입");
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("비밀번호: ");
				member.setPassword(scanner.next());
				System.out.println("이름: ");
				member.setName(scanner.next());
				memberService.join(member);
				break;
			case 2: // 2. 로그인
				System.out.println("로그인");
				member = new Member();
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("비밀번호: ");
				member.setPassword(scanner.next());
				String result= memberService.login(member);
				System.out.println(result);
				break;
			case 3: // 3. 회원목록
				System.out.println("목록보기");
				Member[] list= memberService.list();
				for(int i=0;i < 3;i++) {
					System.out.println(list[i].toString());
				}
				break;
			case 4: // 4. 아이디 중복체크
				System.out.println("아이디 체크");
				member = new Member();
				System.out.println("아이디: ");
				result= memberService.existId(scanner.next());
				System.out.println(result);
				break;
			case 5: // 5. 비번 수정
				System.out.println("비번 수정");
				member = new Member();
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("변경할 비번: ");
				member.setPassword(scanner.next());
				result= memberService.changePassword(member);
				System.out.println(result);
				break;
			case 6: // 6. 회원탈퇴
				System.out.println("회원탈퇴");
				member = new Member();
				System.out.println("삭제할 아이디: ");
				member.setUserid(scanner.next());
				System.out.println("비번 다시 입력: ");
				member.setPassword(scanner.next());
				result= memberService.withdrawal(member);
				System.out.println(result);
				break;
			case 7: // 7. 아이디검색
				System.out.println("아이디검색");
				member = new Member();
				member = memberService.idSearch(scanner.next());
				System.out.println(member.toString());
				break;
			case 8:	// 8. 이름 검색
				Member[] findedMembers = memberService.nameSearch(scanner.next());
				for(Member m: findedMembers) {
					System.out.println(m.toString());
				}
				break;
			case 9: // 9. 전체 회원수
				System.out.println(memberService.count());
				break; 
			default:
				System.out.println("메뉴에 없는 기능입니다.");
				break;
			}
		}

	}
}
