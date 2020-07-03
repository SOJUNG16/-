package test0703;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myld", "1234");
		map.put("asdf", "1111");
		map.put("myld", "1234");
		
		Scanner s = new Scanner(System.in);
		
		while(true ) {
			System.out.println("id와 password를 입력해주세요");
			System.out.println("id:");
			String id = s.nextLine().trim();
			
			System.out.println("pass:");
			String pass = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("입력하신 아이디는 존재하지 않습니다 다시 입력");
				continue;
			} else {
				if(!map.get(id).equals(pass)) {
					System.out.println("비밀번호가 일치하지 않습니다 다시 입력");
				} else {
					System.out.println("id와 비번이 일치합니다");
					break;
				}
			}
			
		}
	}

}
