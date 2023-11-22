package musicProject;

public class Music {
	// ob1
	private String name = " ";
	private String genre = " ";
	private double length = 0.0;
	private String artist = " ";
	private String lyric = " ";
	private int instrument = 0;

	Music() {

	}

	Music(String name, String genre, double length, String artist, String lyric, int instrument) {

		this.name = name;
		this.genre = genre;
		this.length = length;
		this.artist = artist;
		this.lyric = lyric;
		this.instrument = instrument;

	}

	public String getName() {
		return name;
	}

	public String getGenre() {
		return genre;
	}

	public double getLength() {
		return length;
	}

	public String getArtist() {
		return artist;
	}

	public String getLyric() {
		return lyric;
	}

	public int getInstrument() {
		return instrument;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}

	public String toString() {

		String print = "Your song name is: " + getName() + "\nYour song genre is: " + getGenre()
				+ "\nYour song length is: " + getLength() + "\nYour song Artist is: " + getArtist()
				+ "\nYour song lyric is: " + getLyric() + "\nYour song instrument is: " + getInstrument();

		return print;

	}

}
