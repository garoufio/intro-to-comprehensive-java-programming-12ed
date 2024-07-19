package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter a string and displays the characters at odd positions.
 */
public class Exercise5_48 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String str;
    
    System.out.print("Enter a string: ");
    str = input.nextLine();
    
    if (str.length() > 0) {
      for (int i = 0; i < str.length(); i++) {
        if (i % 2 == 0) System.out.print(str.charAt(i));
      }
    }
  }
  
}
