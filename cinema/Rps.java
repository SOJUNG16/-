package cinema;

import java.util.Random;
import java.util.Scanner;

public class Rps {
   public String  play () {
	   Scanner scanner = new Scanner(System.in);
	      Random random = new Random();
      String result1="";
      while(true) {
         System.out.println("가위바위보 이기면 5000원 깎아주~지!  ==> 1.게임시작");
         switch (scanner.nextInt()) {
         case 1: 
       result1 = game();
       return result1;
         }
      }
   }


public String game() {
	  Scanner scanner = new Scanner(System.in);
      Random random = new Random();
	   String result = "";
	   System.out.println("가위,바위,보를 고르세요.");
      System.out.println("1.가위 2.바위 3.보");
      int player = scanner.nextInt();
      int computer = random.nextInt(3)+1;
     
      
      if(player == 1 && computer == 2){result = "패배";
      }else if(player == 1 && computer == 3){result = "승리";
      }else if(player == 2 && computer == 1){result = "승리";
      }else if(player == 2 && computer == 3){result = "패배";
      }else if(player == 3 && computer == 1){result = "패배";
      }else if(player == 3 && computer == 2){result = "승리";
      }else {result= "무승부";}
      
      String rpsP = rps(player); 
      String rpsC = rps(computer);
      
      
      System.out.println("**********************");
      System.out.println("플레이어: "+ rpsP);
      System.out.println("컴퓨터: " + rpsC);
      System.out.println("플레이어: " + result);
      return result;
   }
   
   private static String rps(int player) {
      String rpsP = "";
      
      switch(player) {
      case 1 : rpsP = "가위"; break;
      case 2 : rpsP = "바위"; break;
      case 3 : rpsP = "보"; break;
      }
      return rpsP;
   }
   

   
}