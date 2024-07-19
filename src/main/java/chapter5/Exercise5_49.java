package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter a string, and displays the number of vowels and consonants in the string. Assume that the
 * letters A, E, I, O, and U are vowels.
 */
public class Exercise5_49 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a string: ");
    String str = input.nextLine();
    input.close();
    
    if (str.length() > 0) {
      int vowelsCount = 0;
      int consonantsCount = 0;
      
      char ch;
      for (int i = 0; i < str.length(); i++) {
        ch = str.charAt(i);
        if (Character.isLetter(ch)) {
          ch = Character.toUpperCase(ch);
          if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') vowelsCount++;
          else consonantsCount++;
        }
      }
      System.out.printf("The number of vowels is '%d'\n", vowelsCount);
      System.out.printf("The number of consonants is '%d'\n", consonantsCount);
    }
  }
  
}
