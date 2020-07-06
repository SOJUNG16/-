package cinema;

public class Movie {
	
	private String movName, movTime;

	public String getMovName() {
		return movName;
	}

	public void setMovName(String movName) {
		this.movName = movName;
	}

	public String getMovTime() {
		return movTime;
	}

	public void setMovTime(String movTime) {
		this.movTime = movTime;
	}

	@Override
	public String toString() {
		return "Movie [movName=" + movName + ", movTime=" + movTime + "]";
	}
}