import java.util.Scanner;
public class HangmanDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		boolean playAgain = false;
		do {
			playAgain = false;
			Hangman game = new Hangman();
			game.run();
			
			System.out.print("Play again (y/n): ");
			String again = sn.nextLine();
			if (again.charAt(0) == 'y') {
				playAgain = true;
			}
			
		} while (playAgain);
		
	}

}
