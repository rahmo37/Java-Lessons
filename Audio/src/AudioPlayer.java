import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AudioPlayer {
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("Black bird.wav");
		AudioInputStream audio = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audio);

		Scanner scanner = new Scanner(System.in);
		String response = "";

		while (!response.equals("Q")) {
			System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
			System.out.println("Enter your choice :");
			response = scanner.next();
			response = response.toUpperCase();

			switch (response) {
			case ("P"):
				clip.start();
				break;
			case ("S"):
				clip.stop();
				break;
			case ("R"):
				clip.setMicrosecondPosition(0);
				break;
			case ("Q"):
				clip.close();
				break;
			default:
				System.out.println("Not a valid response");

			}

		}
		System.out.println("Audio player closing...");

	}

}
