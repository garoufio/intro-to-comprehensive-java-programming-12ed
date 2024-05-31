package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter a character, and then it displays its Unicode.
 */
public class Exercise4_9 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a character: ");
    String str = input.next();
    
    switch (str.length()) {
      case 0:
        System.out.println("No character found");
        break;
      case 1:
        char ch = str.charAt(0);
        System.out.printf("The Unicode for the character '%c' is '%d'\n", ch, (int)ch);
        break;
      default:
        System.out.println("Invalid number of characters");
    }
  }
  
}
