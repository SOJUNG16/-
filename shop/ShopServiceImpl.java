package shop;

import java.util.Scanner;

public class ShopServiceImpl implements ShopService {
	Scanner scan = new Scanner(System.in);
	public static final int MAX = 100;
	Member[] members;
	Product[] prods;
	int memberCnt, prodCnt;

	public ShopServiceImpl() {
		members = new Member[MAX];
		   prods = new Product[MAX];
//		   memberCnt = 1;
//		   members[0] = new Member();
//		   members[0].setId("1");
//		   members[0].setName("1");
//		   members[0].setPw("1");
//		   
//		   prodCnt = 1;
//		   prods[0] = new Product();
//		   prods[0].setCode("1");
//		   prods[0].setName("1");   
//		   prods[0].setPrice(10000);
		   }

	@Override
	public void join() {
			Member member = new Member();
			System.out.println("<회원가입>");
			System.out.println("아이디: ");
			member.setId(scan.next());
			System.out.println("비밀번호: ");
			member.setPw(scan.next());
			System.out.println("이름: ");
			member.setName(scan.next());
			
			boolean flag = false;
			for(int i=0; i<memberCnt; i++) {
				if(member.getId().equals(members[i].getId())) {
					System.out.println("중복된 아이디 입니다");
					flag = true;
					break;
				}
			}
			if(flag==false) {
				members[memberCnt] = member;
				memberCnt++;
			}
		}

	@Override
	public void login() {
		if(memberCnt == 0) {
			System.out.println("저장된 회원이 없습니다.");
			return;
		}	
		Member member = new Member();
		System.out.println("<로그인>");
		member = new Member();
		System.out.println("ID를 입력하세요: ");
		member.setId(scan.next());
		System.out.println("패스워드를 입력하세요: ");
		member.setPw(scan.next());
		String result = "Fail...";
		for(int i = 0; i < memberCnt; i++) {
			if(member.getId().equals(members[i].getId()) 
					&& member.getPw().equals(members[i].getPw())) {
				result = "Sucess!";
				break;
			}
		}		
		System.out.println(result);
		
	}

	@Override
	public void changePw() {
		if(memberCnt == 0) {
			System.out.println("저장된 회원이 없습니다.");
			return;
		}		
		Member member = new Member();
		String result = "존재하지 않는 회원입니다.";
		int idx = 0;
		boolean success = false; 
		while(!success) {
			System.out.println("<비밀번호 변경>");
			member = new Member();
			System.out.println("아이디 입력: ");
			member.setId(scan.next());
			System.out.println("비밀번호 입력: ");
			member.setPw(scan.next());
			for(int i = 0; i < memberCnt; i++) {
				if(member.getId().equals(members[i].getId())
						&& member.getPw().equals(members[i].getPw())) {
					idx = i;
					success = true;
					break;
				}
				if(i == memberCnt-1) {
					System.out.println(result);
				}
			}
		}
		System.out.println("변경하실 비밀번호를 입력하세요.");
		members[idx].setPw(scan.next());

	}

	@Override
	public void myPage() {
		boolean isNotExist = true;
		while(isNotExist) {
			System.out.println("<마이페이지>");
			System.out.println("아이디 입력: ");
			String id = scan.next();
			System.out.println("비밀번호 입력: ");
			String pw = scan.next();
			
			for(int i = 0; i < memberCnt; i++) {
				if(id.equals(members[i].getId()) 
						&& pw.equals(members[i].getPw())) {
					System.out.println(members[i].toString());
					isNotExist = false;
					break;
				}
				if(i == memberCnt-1) { //마지막 배열 인덱스
					System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
				}
			}
		}
	}

	@Override
	public void searchProd() {
		if(prodCnt == 0) {
			System.out.println("저장된 상품이 없습니다.");
			return;
		}	
		boolean isNotExist = true;
		String code = "";
		while(isNotExist) {
			System.out.println("<상품 조회>");
			System.out.println("상품 코드 입력: ");
			code = scan.next();
			
			for(int i = 0; i < prodCnt; i++) {
				if(code.equals(prods[i].getCode())){
					System.out.println(prods[i].toString());
					isNotExist = false;
					break;
				}
				if(i == prodCnt-1) {
					System.out.println("상품코드를 다시 확인해주세요.");
				}
			}
		}
		System.out.println("0: 종료   1: 장바구니 추가");
		switch(scan.nextInt()) {
		case 0:
			return;
		case 1:
			addCart(scan, code);
			break;
		}
	}

	@Override
	public void addCart(Scanner scan, String prodCode) {
		// searchProd 조회 후 실행, 상품코드를 parameter로 받아야할듯.
		// 로그인 수행
		Member member = new Member();
		System.out.println("[로그인]");
		System.out.println("아이디: ");
		String inputId = scan.next();
		System.out.println("비밀번호: ");
		String inputPw = scan.next();
		int cnt = 0;
		for(Member m: this.members) {
			if(m != null && inputId.equals(m.getId()) && inputPw.equals(m.getPw())) {
				member = m;				
				break;
			}
			if(cnt == this.memberCnt-1) {
				System.out.println("일치하는 정보가 없습니다.");
				break;
			}
			cnt++;
		}
		// 상품 정보 받기
		Product prod = new Product();
		for(Product p: this.prods) {
			if(p != null && prodCode.equals(p.getCode())) {
				prod = p;
				break;
			}
		}
		// 카트에 추가
		System.out.println("몇 개를 추가하시겠습니까 ?: ");
		member.getCart().setAmount(scan.nextInt());
		member.getCart().setProd(prod);
		
	}

	@Override
	public void pay(Member member) {
		System.out.println("[ 총 "+member.getCart().getTotalPrice()+"원 결제완료. ]");
		// 포인트 적립
		member.setPoint( (int)(member.getCart().getTotalPrice()*0.1) );
		// 결제하면 멤버의 장바구니를 비워준다.
		member.getCart().setCartCnt(0);
		member.getCart().setTotalPrice(0);
	}


	@Override
	public void myCart(Scanner scan) {
		// 로그인 수행
		Member member = new Member();
		System.out.println("[로그인]");
		System.out.println("아이디: ");
		String inputId = scan.next();
		System.out.println("비밀번호: ");
		String inputPw = scan.next();
		int cnt = 0;
		for(Member m: this.members) {
			if(m != null && inputId.equals(m.getId()) && inputPw.equals(m.getPw())) {
				member = m;				
				break;
			}
			if(cnt == this.memberCnt-1) {
				System.out.println("일치하는 정보가 없습니다.");
				break;
			}
			cnt++;
		}
		// 해당하는 Cart 정보 출력
		System.out.println(member.getCart().toString());
		// 결제 수행 체크
		System.out.println("[0: 나가기 / 1: 결제]");
		switch (scan.nextInt()) {
		case 0:
			return;
		case 1:
			this.pay(member); // 결제기능 수행
			break;
		default:
			System.out.println("잘못된 입력");
			break;
		}
	}

	@Override
	public void removeMember() {
			Member member = new Member();
			if(memberCnt == 0) {
				System.out.println("저장된 회원이 없습니다.");
				return;
			}	
			System.out.println("회원탈퇴");
			System.out.println("삭제할 아이디입력: ");
			member.setId(scan.next());
			System.out.println("비밀번호를 입력해주세요");
			member.setPw(scan.next());
			
			for(int i=0; i<memberCnt; i++) {
				if(member.getId().equals(members[i].getId())
						&& member.getPw().equals(members[i].getPw())) {
					members[i] = members[memberCnt-1];
					members[memberCnt-1] = null;
					memberCnt--;
					System.out.println("탈퇴했습니다");
				}
			}
		}

	@Override
	public void addProd() {
		Product prod = new Product();
		boolean check = false;
		System.out.println("<상품등록>");
		System.out.println("등록하실 상품 이름을 입력하세요: ");
		prod.setName(scan.next());
		do {
		System.out.println("해당 상품 코드를 입력하세요: ");
		String uI = scan.next();
		prod.setCode(uI);
		for (int i = 0; i < prodCnt; i++) {
			if ( prod != null && uI.equals(prods[i].getCode())) {
				System.out.println("이미 존재하는 상품 코드입니다.");
				check=true;
			} else {
				check=false;
			}
		} }while(check);
		System.out.println("해당 상품 가격을 입력하세요: ");
		prod.setPrice(scan.nextInt());
		prods[prodCnt] = prod;
		prodCnt++;
	}

	@Override
	public void removeProd() {
		//Product prod = new Product();
		boolean check = false;
		do {
		System.out.println("<상품삭제>");
		System.out.print("삭제하실 상품 코드를 입력하세요: ");
		String uI = scan.next();
			for (int i = 0; i < prodCnt; i++) {
				if (prods != null && uI.equals(prods[i].getCode())) {
					prods[i] = prods[prodCnt - 1];
					prods[prodCnt - 1] = null;
					prodCnt--;
					System.out.println("삭제되었습니다.");
					check = false;
				break;
				} else {
					check = true;
				} if (i == prodCnt-1) { 
					System.out.println("없는 제품 코드입니다. 확인 후 다시입력하세요.");
					
				}
			}
		} while (check);
		
	}

	@Override
	public void searchMember() {
		Member member = new Member();
		boolean check = false;
		if(memberCnt == 0) {
			System.out.println("저장된 회원이 없습니다.");
			return;
		}
	do {
		System.out.println("<회원정보조회>");
		System.out.println("검색할 회원ID를 검색하세요: ");
		String uI = scan.next();
		for(int i= 0; i < memberCnt; i++) { 
			if (uI.equals(members[i].getId())) {
				System.out.println(members[i].toString());
				check = false;
				break;
			}else {
				check =true;
			} if (i == memberCnt-1) {
				System.out.println("없는 회원입니다. 확인 후 다시 입력하세요.");
			}
		}
	} while(check);

	}

}
