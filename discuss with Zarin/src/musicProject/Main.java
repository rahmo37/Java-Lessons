package musicProject;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner music = new Scanner(System.in);
		Music[] musicArr = new Music[1];
		System.out.println("Answer the following questions: ");

		for (int i = 0; i < musicArr.length; i++) {

			musicArr[i] = new Music();

			System.out.println("The name of the song");
			musicArr[i].setName(music.nextLine());
			System.out.println("The genre of the song");
			musicArr[i].setGenre(music.nextLine());
			System.out.println("The artist of the song");
			musicArr[i].setArtist(music.nextLine());
			System.out.println("The lyric of the song");
			musicArr[i].setLyric(music.nextLine());
			System.out.println("The length of the song");
			musicArr[i].setLength(music.nextDouble());
			System.out.println("The instrument of the song");
			musicArr[i].setInstrument(music.nextInt());
			music.nextLine();

			System.out.println(musicArr[i]);
		}
		
		System.out.println("Great collection of songs");

	}

}
