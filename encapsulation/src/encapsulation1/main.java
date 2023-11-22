package encapsulation1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Unable to access the private variables/field from the song class
		//so we are requesting the song class to change the values for s object
		//and print it
		
		song s = new song("Chiro Odhora", "Melody", "Tushar Hasan");
		s.setSong("Grace");
		s.setSongGenre("Groove Metal");
		s.setSongWriter("Lamb of God");
		System.out.println(s.getSong() + "\n" + s.getSongGenre() + "\n" + s.getSongWriter());
	}

}
