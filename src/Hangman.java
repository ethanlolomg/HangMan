/*
 * A list of words
 * the word we are trying to guess
 * the word as displayed to the user
 * the number of incorrect guesses
 * max number of incorrect guesses
 * 
 * A keyboard input
 * 
 * console output
 * 
 * 
 * 
 */
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	private String[] words = {"java", "python", "pizza", "potato", "fizzy", "dizzy"};
	private String[] hanged = {"   --------\\",		//0
			                   "   |       |",
			                   "   O       |",
			                   "  /|\\      |",
			                   "   |       |",
			                   "   |       |",		//5
			                   "  / \\      |",
			                   " |   |     |",
			                   "           |",
			                   "___________|"};
	private String[] nothanged = {"   --------\\",  //0
					              "           |",   //1
					              "           |",	//2
					              "           |",
				                  "           |",
					              "           |",
					              "           |",
					              "           |",
					              "           |",
					              "___________|"};
	
	private String word;
	private String displayWord;
	private int numberOfGuesses;
	private int wrongGuesses;
	private int maxGuesses;
	private Random rng;
	private Scanner sn;
	
	Hangman() {
		rng = new Random();
		sn  = new Scanner(System.in);
		int wordIndex = rng.nextInt(words.length);
		word = words[wordIndex];
		displayWord = initWord(word);
		numberOfGuesses = 0;
		wrongGuesses = 0;
		maxGuesses = 7;
	}
	
	private void showMan() {
		for (int i = 0; i <= wrongGuesses; i++) {
			System.out.println(hanged[i]);
		}
		for (int i = wrongGuesses + 1; i < nothanged.length; i++) {
			System.out.println(nothanged[i]);
		}	
	}
	
	private String initWord(String word2) {
		String output = "";
		for (int i = 0; i < word2.length(); i++) {
			output += "_";
		}
		return output;
	}
	
	private String letterPut(String orig, String cur, char ch) {
		for (int i = 0; i < orig.length(); i++) {
			if (orig.charAt(i) == ch) {
				char[] chword = cur.toCharArray();
				chword[i] = ch;
				cur = String.copyValueOf(chword);
			}
		}
		return cur;
	}
	
	void display() {
		System.out.println(numberOfGuesses + " attempts.");
		System.out.println(wrongGuesses + " Wrong guesses.");
		for (int i = 0; i < displayWord.length(); i++) {
			System.out.print(displayWord.charAt(i));
			System.out.print(' ');
		}
		System.out.println();
		this.showMan();
		System.out.println();
		//System.out.println(displayWord);
	}
	
	void run() {
		boolean playing = true;
		while (playing) {
			display();
			System.out.print("Enter a letter: ");
			String input = sn.nextLine();
			char ch = input.charAt(0);
			numberOfGuesses++;
			
			if (word.indexOf(ch) > -1) {
				displayWord = letterPut(word, displayWord, ch);
			} else {
				wrongGuesses++;
			}
			
			if (wrongGuesses >= maxGuesses) {
				playing = false;
				System.out.println();
				showMan();
				System.out.println();
				System.out.println("Game over! You lose!");
			}
			
			if(word.contentEquals(displayWord)) {
				playing = false;
				System.out.println("Congrats you win!");
			}
		}
	}
	
	
	
	
	
	
	
}
