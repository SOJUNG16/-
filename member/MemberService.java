package member;

interface MemberService {
	// 1. 회원가입
	public void join(Member member);
	// 2. 로그인
	public String login(Member member);
	// 3. 회원목록
	public Member[] list();
	// 4. 아이디 중복체크
	public String existId(String id);
	// 5. 비번수정
	public String changePassword(Member member);
	// 6. 회원탈퇴
	public String withdrawal(Member member);
	// 7. 아이디 검색
	public Member idSearch(String id);
	// 8. 이름검색
	public Member[] nameSearch(String name);
	// 9. 전체 회원수
	public int count();
}


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
