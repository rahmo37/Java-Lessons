package encapsulation1;

public class song {
	private String song;
	private String songGenre;
	private String songWriter;

	song(String song, String songGenre, String songWriter) {
		this.setSong(song);
		this.setSongGenre(songGenre);
		this.setSongWriter(songWriter);

	}

	public String getSong() {
		return song;
	}

	public String getSongGenre() {
		return songGenre;
	}

	public String getSongWriter() {
		return songWriter;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public void setSongGenre(String songGenre) {
		this.songGenre = songGenre;
	}

	public void setSongWriter(String songWriter) {
		this.songWriter = songWriter;
	}
}
