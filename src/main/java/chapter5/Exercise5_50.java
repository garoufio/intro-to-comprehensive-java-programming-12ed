package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter a string and displays the number of the uppercase letters in the string.
 */
public class Exercise5_50 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a string: ");
    String str = input.nextLine();
    input.close();
    
    if (str.length() > 0) {
      int count = 0;
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') count++;
      }
      System.out.printf("The number of uppercase letters is '%d'\n", count);
    }
  }
  
}
