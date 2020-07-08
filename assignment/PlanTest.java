package assignment;

import java.util.HashSet;
import java.util.Objects;

class Plane {
	private String model, airline;
	private HashSet fixHis;
	
	Plane() {
	}
	
	Plane(String model, String airline) {
		this.model = model;
		this.airline = airline;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public HashSet getFixHis() {
		return fixHis;
	}
	public void setFixHis(HashSet fixHis) {
		this.fixHis = fixHis;
	}
	
	public void addFixHis(FixHis his) { //수리이력추가
		HashSet fixhis = new HashSet();
		fixhis.add(new FixHis());
		
	}
	public void printFixHis() {
		
	}
}
class FixHis { //HashSet
	private String airport, date, cmt;
	
	FixHis() {
	}
	FixHis(String airport, String date, String cmt) {
		this.airport = airport;
		this.date = date;
		this.cmt = cmt;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public boolean equals(Object obj) {
		if(obj instanceof FixHis) {
			FixHis tmp = (FixHis)obj;
			return airport.equals(tmp.airport) && date.equals(tmp.date)
					&& cmt.equals(tmp.cmt);
		}
		return false;
	}
	public int hashCode() {
		return Objects.hash(airport,date,cmt);
	}
	
}

public class PlanTest {
	public static void main(String[] args) {
		Plane plan = new Plane("모델1","비행기1");
		Plane plan2 = new Plane("모델2","비행기2");
		Plane plan3 = new Plane("모델3","비행기3");
		
		FixHis his = new FixHis("공항1","20200708","수리1");
		FixHis his2 = new FixHis("공항2","20200708","수리2");
		FixHis his3 = new FixHis("공항3","20200708","수리3");
		
	}

}
