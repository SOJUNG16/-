package cinema;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class CinemaServiceImpl implements CinemaService{
	// 상수영역
	public static final String FIRST_TIME = "10:00";
	public static final String SECOND_TIME = "14:00";
	public static final String THIRD_TIME = "16:00";
	
	MovieRoom[] movieRoom;
	Map members;	
	Map movies;
	Rps rps;
	
	public CinemaServiceImpl() {
		this.rps = new Rps();
		this.movieRoom = new MovieRoom[3];
		for(int i = 0 ; i < 3;  i++) {
			this.movieRoom[i] = new MovieRoom();
		}
		this.members = new HashMap<String, Member>();	// key는 id, value는 멤버클래스
		this.movies = new HashMap<String, String[]>();	// key는 영화이름, value는  시간, 관 정보
	}
	
	   @Override
	   public void join(Scanner scan) {
	        System.out.println("ID 입력: ");
	        String id = scan.next();
	        System.out.println("PASSWORD 입력: ");
	        String password = scan.next();
	        boolean idCheck = false;
	        String key;
	        Set set = members.keySet();
	        Iterator itr = set.iterator();
	        while(itr.hasNext()) {
	           key = (String)itr.next();
	           if(key.equals(id)) {
	              idCheck = true;
	           }
	        }
	        
	     if(idCheck == true) {
	        System.out.println("중복된 ID입니다.");
	     }else {
	       System.out.println("이름 입력: ");
	       String name = scan.next();
	       Member member = new Member(password, name);
	        members.put(id, member);
	        System.out.println("회원가입이 완료되었습니다.");
	     }
	  }

	  @Override
	  public String login() {
	     Scanner scan = new Scanner(System.in);
	        HashMap hashMap = new HashMap();
	        String id ="";
	        while(true) {
	           System.out.println("ID와 PASSWORD를 입력해 주세요.");
	           System.out.print("ID: ");
	           id = scan.nextLine().trim();
	           System.out.print("PASSWORD: ");
	           String password = scan.nextLine().trim();
	           System.out.println();
	           Member tmp = (Member)members.get(id);
	           
	           if(!members.containsKey(id)) {
	              System.out.println("입력하신 ID는 존재하지 않습니다.");
	              continue;
	           } else {
	              if(!(tmp.getPw()).equals(password)) {
	                 System.out.println("비밀번호가 일치하지 않습니다.");
	              } else {
	                 System.out.println("로그인에 성공하셨습니다.");
	                 break;
	              }
	           }
	        }
	        return id;
	  }

	  
	   @Override
	   public void myPage(Scanner scan) {
	           String id = login();
	           System.out.println(members.get(id));
	   }


	@Override
	public void searchMov(Scanner scan) {	//예매하기

		
		System.out.println("[ 예매하기 ]");
		while(true) {
			System.out.println("1. 예매하기   2. 전체시간표   0. 종료");
			int inputNum = scan.nextInt();
			if(inputNum == 0)	return;
			else if(inputNum == 1) {
				pay(scan);
			}else if(inputNum == 2) {
				// 전체 상영시간출력
				boxOffice();
			}else {
				System.out.println("잘못된 입력");
			}
		}		
	}

	@Override
	public void pay(Scanner scan) {
		Random rand = new Random();
		Calendar bookDate = Calendar.getInstance();
		int year = bookDate.get(Calendar.YEAR);
		int month = bookDate.get(Calendar.MONTH)+1;
		int date = bookDate.get(Calendar.DATE);
		int ranNum = (int)((Math.random()*100)+1);
		String bookNum = String.join("", year+"",month+"",date+"-",ranNum+"");
		
		System.out.println("<영화 예매>");
			String id = login();
			
			System.out.println("<보기로 한 영화가 뭐예요~?>");
			String movieName = scan.next();
			if ((this.movies).containsKey(movieName)) {
				System.out.println("몇 시에 볼거야~?");
				System.out.println("[1: 10시\t2: 2시\t3: 4시]");
				int time = scan.nextInt();
				System.out.println("몇 명이 볼 거예요~?");
				int people = scan.nextInt();
				int price = people * 50000;
				if (rps.play().equals("승리")) {
					System.out.println("와우! 행운의 여신이 당신에게! 5000원 할인!");
					System.out.println("이제 계산해볼까요~");
					System.out.println("포인트를 쓸래요~?");
					System.out.println("1: 네!    2: 아뇨!");
					switch (scan.nextInt()) {
				case 1:
					Member tmp = (Member)this.members.get(id);
					price = price - tmp.getPoint();
					tmp.setPoint(0);
					members.put(id, tmp);
					break;
				case 2: 
					break;
				}
					System.out.println("[ 총 " + (price - 5000) + "원 결제완료. ]");
					// 포인트 적립
					int point = (int) (price * 0.1);
					Member tmp = (Member)this.members.get(id);
					tmp.setPoint(point);
					tmp.setBookNum(bookNum);
					members.put(id, tmp);
					System.out.println("포인트" + (price * 0.1) + "가 지급되었습니다!");
					price = 0;
					System.out.println("결제 완료! 이제 영화보러 가세요!");
//					Calendar bookDate = Calendar.getInstance();
//					int today = bookDate.get(Calendar.SHORT_FORMAT);
//					System.out.println(today);
					return;
				} else {
					System.out.println("저런.. 꽝!");
					System.out.println("이제 계산해볼까요~");
					System.out.println("포인트 쓸래요~?");
					System.out.println("1: 네!    2: 아뇨!");
					switch (scan.nextInt()) {
					case 1:
						Member tmp = (Member)this.members.get(id);
						price = price - tmp.getPoint();
						tmp.setPoint(0);
						members.put(id, tmp);
						break;
					case 2: 
						break;
					}
					System.out.println("[ 총 " + price + "원 결제완료. ]");
					// 포인트 적립
					int point = (int) (price * 0.1);
					Member tmp = (Member)this.members.get(id);
					tmp.setBookNum(bookNum);
					tmp.setPoint(point);
					members.put(id, tmp);
					System.out.println("포인트" + (price * 0.1) + "가 지급되었습니다!");
				}
				price = 0;
				System.out.println("결제 완료! 이제 영화보러 가세요!");
				return;
			} else {
				System.out.println("영화 제목을 다시 확인해볼까~?");
			}
	}

	@Override
	public void addEvent() {
		Calendar today = Calendar.getInstance();
			
	System.out.println("<<2020 이벤트를 확인하세요~!>>");
		System.out.println("*KID CULTURE DAY*");
		System.out.println("이 달의 마지막 날!! 50% 할인된 가격으로 영화를 보아요!");
		int year= 2020;
		int month = 6;
		
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		sDay.set(year, month-1, 1);
		eDay.set(year, month, 1);
		
		eDay.add(Calendar.DATE,  -1);
		
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		END_DAY = eDay.get(Calendar.DATE);
		
		System.out.println("  "+year+"년 " + month +"월 ");
		System.out.println(" SU MO TU WE TH FR SA");
		
		for(int i=1; i<START_DAY_OF_WEEK; i++) {
			System.out.print("   ");
		}
		
		for(int i =1, n=START_DAY_OF_WEEK ; i <=END_DAY; i++, n++) {
			System.out.print((i<10)? "  "+i: " "+i );
			if(n%7==0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println( "\n 어?? 이번 달의 마지막 날이 언제더라~~? \n 바로바로~~~ "  + today.getActualMaximum(Calendar.DATE) +"일 이네요!!"); 

	}

	@Override
	public void addMov(Scanner scan) {
		//	System.out.println(this.movies);
		System.out.println("[ 영화등록 ]");
		while(true) {
			System.out.println("영화 이름 입력");
			String movieName = scan.next();
			if((this.movies).containsKey(movieName)) {
				System.out.println("이름 중복!");
				System.out.println();
				continue;
			}
			else {
				(this.movies).put(movieName, null);
				break;
			}
		}
	}

	@Override
	public void setMovRoom(Scanner scan) {
		// 1 ~ 3관중 체크 후 시간입력 후, 영화등록 <- 0: 1관, 1: 2관, 2: 3관
		System.out.println("[ 상영관 설정 ]");
		while(true) {
			System.out.println("상영관 번호[0:종료]: ");
			int inputNum = scan.nextInt();
			if(inputNum == 0)	return;	//종료
			if(inputNum < 1 || inputNum > 3) {
				System.out.println("1~3 중 입력해주세요.");
				continue;
			}
			inputNum--;	// 인덱스 번호 접근을 위해 -1
			// 시간입력
			while(true) {
				System.out.println("1. "+FIRST_TIME);
				System.out.println("2. "+SECOND_TIME);
				System.out.println("3. "+THIRD_TIME);
				System.out.println("시간선택: ");
				int inputTime = scan.nextInt();
				// 입력 체크 영역
				if(inputTime < 1 || inputTime > 3) {	// 입력체크
					System.out.println("1~3 중 입력해주세요.");
					continue;
				}
				if((this.movieRoom[inputNum]).getMovieTime().containsKey(inputTime)) {	// 해당 시간에 값이 있을경우
					System.out.println("해당 시간에 상영중인 영화가 있습니다.");
					continue;
				}
				// 영화정보 입력
				while(true) {
						System.out.println("영화 제목을 입력해주세요.");
						String inputTitle = scan.next();
						if(!(this.movies).containsKey(inputTitle)) {	// 현재 movies중  제목이 있는지 확인
							System.out.println("영화가 존재하지 않습니다.");
							continue;
						}else {
							Map movieInfo = new HashMap();
							movieInfo.put(inputTitle, (inputNum+1)+"관");
							String movieInputTime = null;
							switch (inputTime) {
							case 1:	movieInputTime = FIRST_TIME;	break;
							case 2:	movieInputTime = SECOND_TIME;	break;
							case 3:	movieInputTime = THIRD_TIME;	break;
							}
							// 영화관 인덱스에 시간과 영화정보를 넣어줌
							(this.movieRoom[inputNum]).getMovieTime().put(movieInputTime, movieInfo);
							// 영화에도 시간정보를 들어가게
							String[] movieInput = {movieInputTime, (inputNum+1)+"관"};
							(this.movies).put(inputTitle, movieInput);
							break;
						}					
				} // 영화정보 입력 끝
				break;
			}// 시간입력 끝
			break;
		} // 영화관 정보 끝
	}

	@Override
	public void memberList() {
		Set<Map.Entry> entry = members.entrySet();
		for(Map.Entry e: entry) {
			System.out.println("ID= "+ e.getKey() + ", " +e.getValue());
		}
	}

	@Override
	public void boxOffice() {
		for(int i = 0; i < movieRoom.length; i++) {
			System.out.println("["+(i+1)+"관]");
			System.out.println(this.movieRoom[i]);
		}
	}
	
}
