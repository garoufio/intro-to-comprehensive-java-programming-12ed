package chapter7;

import java.util.Scanner;

/**
 * Write a hangman game that randomly generates a word and prompts the user to guess one letter at a time. Each letter
 * in the word is displayed as an asterisk. When the user makes a correct guess, the actual letter is then displayed.
 * When the user finishes a word, display the number of misses and ask the user whether to continue to play with another
 * word.
 */
public class Exercise7_35 {
  
  public static final String[] WORDS = {
    "programming", "java", "software", "test", "develop",
    "coffee", "keyboard", "mouse", "computer", "monitor",
  };
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    play();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void play() {
    Scanner input = new Scanner(System.in);
    String word;
    
    do {
      word = getRandomWord();
      guess(input, word.toCharArray());
    } while (continuePlaying(input));
    
    input.close();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String getRandomWord() {
    int index = (int)(Math.random() * WORDS.length);
    return WORDS[index];
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean continuePlaying(Scanner scanner) {
    char answer;
    
    System.out.print("Do you want to guess another word? Enter 'y' or 'n': ");
    for (;;) {
      answer = scanner.next().charAt(0);
      if (answer == 'y' || answer == 'n') break;
      
      System.out.print("Invalid answer. Please enter 'y' or 'n': ");
      scanner.nextLine();
    }
    return answer == 'y';
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void guess(Scanner scanner, char[] word) {
    int countMiss = 0;
    char letter;
    boolean[] unmaskedChars = new boolean[word.length];
    
    for (;;) {
      System.out.printf("(Guess) Enter a letter in word '%s' > ", maskWord(word, unmaskedChars));
      letter = scanner.next().charAt(0);
      if (charsFound(letter, word, unmaskedChars)) {
        if (wordFound(unmaskedChars)) break;
      } else {
        System.out.printf("'%c' is not in the word\n", letter);
        countMiss++;
      }
    }
    System.out.printf(
        "Congratulations! The word is '%s'. You missed '%d' time%s\n",
        String.valueOf(word), countMiss, countMiss == 1 ? "" : "s"
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String maskWord(char[] word, boolean[] unmaskChars) {
    char[] maskedWord = new char[word.length];
    
    for (int i = 0; i < word.length; i++) {
      maskedWord[i] = unmaskChars[i] ? word[i] : '*';
    }
    return new String(maskedWord);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean charsFound(char letter, char[] word, boolean[] unmaskChars) {
    boolean found = false;
    
    for (int i = 0; i < word.length; i++) {
      if (word[i] == letter) {
        unmaskChars[i] = true;
        found = true;
      }
    }
    return found;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean wordFound(boolean[] unmaskChars) {
    boolean found = true;
    
    for (boolean unmask : unmaskChars) {
      if (!unmask) return false;
    }
    return found;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
