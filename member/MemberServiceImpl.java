package member;

// Memeber class에 입력된 멤버정보를 한곳으로 모으기 위해서
// [] 덮어쓰지 않고 계속 쌓이기 위해서 공간을 여러개 줌

public class MemberServiceImpl implements MemberService{
	private Member[] members; 
	private int idx = 0; //idx 배열 순서 0번 1번 2번
	
	public MemberServiceImpl() {
		members = new Member[3];
		idx = 0; //variable의 형태
	}
    @Override
	public void join(Member member) {
		System.out.println("App 에서 넘어온 회원 정보");
		System.out.println(member.toString());
		members[idx] = member;
		idx++;
		System.out.println("증가된 인덱스 값: "+idx);
		System.out.println("배열에 저장된 회원정보");
		
		for(int i=0; i < members.length; i++) {
			if(members[i] != null) {
			System.out.println(members[i].toString());
			} else {
				System.out.println("회원정보가 없습니다.");
			} 
		}
		
    }
	@Override
	public void login() {
		
	}
	@Override
	public Member[] list() {
		return members;
	}

}
