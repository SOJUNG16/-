package member;

// Memeber class에 입력된 멤버정보를 한곳으로 모으기 위해서
// [] 덮어쓰지 않고 계속 쌓이기 위해서 공간을 여러개 줌

public class MemberServiceImpl implements MemberService{
	private Member[] members; 
	private int count; //idx 배열 순서 0번 1번 2번
	
	public MemberServiceImpl() {
		members = new Member[3];
		count = 0; //variable의 형태
	}
    @Override
	public void join(Member member) {
		members[count] = member;
		count++;
			} 
		
	@Override
	public String login (Member member) {
		String result = "FAIL";
		for(int i=0; i< count; i++) {
			if( member.getUserid().equals(members[i].getUserid())
					&& member.getPassword().equals(members[i].getPassword())) {
			result = "SUCCESS";
			break;
			} 
		}
		return result;
	}		


	@Override
	public Member[] list() {
		return members;
	}
	
	@Override
	public String existId(Member member) {
		System.out.println("중복 체크할 아이디: "+member.getUserid());
		String result = "중복없음";
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				result = "중복된 아이디";
			}	
		}
		return result;
	}
		
	}

