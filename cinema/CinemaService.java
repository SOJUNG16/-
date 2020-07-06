package cinema;

import java.util.Scanner;

public interface CinemaService {
	
	public void join(Scanner scan);	
	public Object login();
	public void myPage(Scanner scan);
	public void searchMov(Scanner scan);	
	public void pay(Scanner scan);
	public void addEvent();	
	public void addMov(Scanner scan);
	public void setMovRoom(Scanner scan);	
	public void memberList();
	public void boxOffice();
}
