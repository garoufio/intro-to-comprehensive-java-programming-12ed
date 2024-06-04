package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter a string, and then it displays its length and the first character of the input string.
 */
public class Exercise4_20 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a string: ");
    String str = input.nextLine();
    input.close();
    
    System.out.printf("The length of the string is '%d' and its first character is '%c'\n", str.length(), str.charAt(0));
  }
  
}
