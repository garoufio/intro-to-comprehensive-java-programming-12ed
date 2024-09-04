package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter a string, and the program counts and displays the number of the letters in the string.
 */
public class Exercise6_20 {
  
  public static String readInput(Scanner scanner) {
    System.out.print("Enter a string: ");
    return scanner.nextLine();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int countLetters(String str) {
    int lettersCount = 0;
    
    for (char ch : str.toCharArray()) {
      if (Character.isLetter(ch)) lettersCount++;
    }
    
    return lettersCount;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = readInput(scanner);
    scanner.close();
    
    System.out.printf("The string '%s' contains '%d' letters.\n", str, countLetters(str));
  }
  
}
