package test0702;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableEx {
	public static void main(String[] args) {
		List pointList = new ArrayList();
		pointList.add(new Point(5,6));
		pointList.add(new Point(7,9));
		pointList.add(new Point(2,5));
		Collections.sort(pointList);
		System.out.println(pointList);
	}

}
class Point implements Comparable{ //정렬기준 재정의
	int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(x="+x+",y="+y+")";
	}

	@Override
	public int compareTo(Object p) {
		if(this.x > ((Point)p).x) {
			return 1; //x에 대해서는 오름차순
		}
		else if(this.x == ((Point)p).x) {
			if(this.y < ((Point)p).y) { //y에 대해서는 내림차순
				return 1;
			}
		}
		return -1;
	}
	
	
}