package member;

// Memeber class에 입력된 멤버정보를 한곳으로 모으기 위해서
// [] 덮어쓰지 않고 계속 쌓이기 위해서 공간을 여러개 줌

public class MemberServiceImpl implements MemberService{
	private Member[] members; //회원목록 전체
	private int count; //idx 배열 순서 0번 1번 2번
	
	public MemberServiceImpl() {
		members = new Member[3];
		count = 0; //variable의 형태
	}
	// 1.회원가입
    @Override
	public void join(Member member) {
		members[count] = member;
		count++;
			} 
	// 2.로그인	
	@Override
	public String login (Member member) {
		String result = "FAIL";
		for(int i=0; i< count; i++) {
			if( member.getUserid().equals(members[i].getUserid())
					&& 
				member.getPassword().equals(members[i].getPassword())) {
			result = "SUCCESS";
			break; 
			} 
		}
		return result;
	}		
    // 3.회원목록
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
				result = "중복된 아이디";
			}	
		}
		return result;
	}
	// 5. 비밀번호 수정 (아이디는 기존과 동일 비번은 다름)
	@Override
	public String changePassword(Member member) {
		String result = "수정실패";
		for(int i=0 ; i < count; i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				members[i].setPassword(member.getPassword()); //get 꺼내고 set안에 넣어줌
				result ="수정성공";
				break;
				}
			}
		return result;
	}
	//6.회원탈퇴
	@Override
	public String withdrawal(Member member) {
		String result = "탈퇴실패";
		for(int i=0; i<count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
				&& member.getPassword().equals(members[i].getPassword())) {
			members[i] = members[count-1];//탈퇴하면 생기는 빈칸에 맨 뒤에 값(count-1)을 채워줘야함
			members[count-1] = null;
			count--; //
			result = "탈퇴성공";
			break;
		}
			}
		return result;
	}
	//7.아이디 검색
	@Override
	public Member idSearch(String id) {
		Member member = new Member();
		for(int i=0; i<members.length; i++) {
			if(id.equals(members[i].getUserid())) {
				member = members[i];
				break;
			}
		}
		return member;
	}
	//8.이름검색(동명이인 처리 필요)
	@Override
	public Member[] nameSearch(String name) {
		int cnt = 0; //동명이인 수
		for(int i=0; i<members.length; i++) {
			if(name.equals(members[i].getName())) {
				cnt++;
			}
		}
		Member[] searchMembers = new Member[cnt];
		int k = 0;
		for(int i=0; i< members.length; i++) {
			if(name.equals(members[i].getName())) {
				searchMembers[k] = members[i];
				k++;
				if(k == cnt) break;
			}
		}
		return searchMembers;
	}
	//9.전체 회원수
	@Override
	public int count() {
		return count;
	}
}		


