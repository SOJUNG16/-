package cinema;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MovieRoom {
	private Map movieTime;
	public static final int sitLimit = 20;
	
	MovieRoom() {
		movieTime = new HashMap<String ,HashMap>();	// key는 time, Hash내에 영화정보, 관의 이름...
	}
	

	public Map getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(Map movieTime) {
		this.movieTime = movieTime;
	}


	@Override
	public String toString() {
		String result = "";
		Set<Map.Entry<String, HashMap>> entry = (this.movieTime).entrySet();
		for(Map.Entry<String, HashMap> e: entry) {
			result += e.getKey() +" - "+ e.getValue() +"\n";
		}
		return result;
		//return (this.movieTime).toString();
	}

	
}