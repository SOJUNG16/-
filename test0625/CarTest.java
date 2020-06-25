package test0625;

import java.util.Scanner;

//• 실습: 차량판매시스템
//선택하세요. [0:나가기, 1:차량등록, 2:고객등록, 3. 차량조회, 4: 고객조회, 5:차량판매]
//[차량등록]
//차량번호: 111
//차량크기(소형(1)/중형(2)/대형(3)): 2
//차량타입(세단(1)/SUV(2)): 1
//[고객등록]
//고객번호: 122
//고객명: 홍길동
//[차량조회]
//차량번호: 111
//차량크기(소형(1)/중형(2)/대형(3)): 2
//차량타입(세단(1)/SUV(2)): 1
//--------------
//[고객조회]
//고객번호: 111
//고객명: 홍길동
//-------------
//[차량판매]
//고객번호를 등록하세요[0:취소]: 122
//차량번호를 등록하세요[0:취소]: 111
//====================================================================
//* 차량등록 시 중복체크
//   ‘차량번호가 중복됩니다’ //배열에 넣은거랑 비교
//* 차량판매 시
//   - 존재하는 고객번호일 때까지 ‘고객번호를 등록하세요’
//   - 존재하는 차량번호일 때까지 ‘차량번호를 등록하세요’
// - 판매된 차량번호이면 ‘판매된 차량번호 입니다. 차량번호를 등록하세요’

class Car{
	int num;
	int size;
	int type;
}
class Customer {
	String name;
	int id;
}
public class CarTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = 0;
		int type = 0;
		int idx = 0;
		int idx2 =0;
		
		Car [] cars = new Car[100];
		Customer [] customers = new Customer[100]; //각각 따로 다루고 있기 때문에 배열2개필요 차량을 가지고 있는 사람이 고객아니고 고객은 따로 등록
		
		Car car = null; // new Car
		Customer cus = null;
		while(true){
			System.out.println("선택하세요>> [0:나가기, 1:차량등록, 2:고객등록, 3. 차량조회, 4: 고객조회, 5:차량판매]");
			switch (scanner.nextInt()) {
			case 0: System.out.println("나가기"); return;
			case 1: //차량등록
				car = new Car();
				System.out.println("[차량등록]");
				System.out.println("차량번호를 입력하세요");
				car.num= scanner.nextInt();
				System.out.println("차량 크기를 선택하세요 [1.소형 2.중형 3. 대형] ");
				car.size = scanner.nextInt();
				if(car.size==1) {
					System.out.println("1.소형");
				} else if(car.size==2) {
					System.out.println("2. 중형");
				} else if(car.size==3) {
					System.out.println("3. 대형");
				}
				System.out.println("차량 타입을 선택하세요 [1.세단 2.SUV] ");
				car.type = scanner.nextInt();
				if(car.type==1) {
					System.out.println("1.세단");
				} else if(car.type==2) {
					System.out.println("2. SUV");
				} 
				
				boolean flag = false; //boolean 사용해서 중복체크
				for(int i=0; i<idx; i++) {  //배열크기만큼 돌면 nullpoint오류발생 따라서 넣은만큼 돌리게 idx사용
					if(car.num == cars[i].num) {
						System.out.println("차량번호가 중복됩니다");
						flag= true; //true로 안바뀌면 false라 밑에것 진행
					}
				}
				if(flag==false) { // = !flag
					cars[idx] = car;
					idx++;
				}
				
				break;
			case 2 :// 고객등록
				cus = new Customer();
				System.out.println("[고객등록]");
				System.out.println("고객번호를 입력하세요");
				cus.id = scanner.nextInt();
				System.out.println("고객명을 입력하세요");
				cus.name = scanner.next();
				customers[idx2] =cus;
				idx2++;
				break;
				
			case 3 : //차량조회
				System.out.println("[차량조회]");
				for(Car c : cars) {
					if(c != null) {
						System.out.println("차량번호 :" +c.num);
						System.out.println("차량크기(소형(1)/중형(2)/대형(3)): " +c.size);
						System.out.println("차량타입(세단(1)/SUV(2)): " +c.type);
						System.out.println("----------------------");
					}
				} 
				break;
			case 4 : //고객조회
				System.out.println("[고객조회]");
				for(Customer cu : customers) {
					if(cu != null) {
						System.out.println("고객번호 :" +cu.id);
						System.out.println("고객명: " +cu.name);
						System.out.println("----------------------");
					}
				}
				break;
			case 5 :
				System.out.println("[차량판매]");
			default:
				break;
			}
		}
	}
	
	
}

