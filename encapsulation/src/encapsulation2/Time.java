package encapsulation2;

public class Time {
	private int hour;
	private int minute;
	private int second;

	Time() {
		this(0, 0, 0);
	}

	Time(int hour) {
		this(hour, 0, 0);
	}

	Time(int hour, int minute) {
		this(hour, minute, 0);
	}

	Time(int hour, int minute, int seconds) {
		this.setTime(hour, minute, seconds);
	}

	// 12 //33 //50
	public void setTime(int hour, int minute, int second) {
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

								
	public void setHour(int hour) {			  
		if (hour >0 && hour< 24) {
			this.hour = hour;
		}
		else {
			this.hour = 0;
		}
	}

							// 42
	public void setMinute(int minute) { 			// 42
		// another way of writing if statement
		this.minute = ((minute > 0 && minute < 60) ? minute : 0);
	}

								// 59
	public void setSecond(int second) { 			// 59
		this.second = ((second > 0 && second < 60) ? second : 0);
	}

	public int getHour() {
		return this.hour;
	}

	public int getMinute() {
		return this.minute;
	}

	public int getSecond() {
		return this.second;
	}

	public String toString() {
		//padding 0 with string.format method
		return String.format("%02d:%02d:%02d", this.getHour(), this.getMinute(), this.getSecond());
	}
}
