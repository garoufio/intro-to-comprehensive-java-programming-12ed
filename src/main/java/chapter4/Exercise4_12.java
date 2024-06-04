package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter a hex value, and then it converts and displays its corresponding binary number.
 */
public class Exercise4_12 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a hex digit: ");
    String hex = input.next();
    input.close();
    
    if (hex.length() != 1) {
      System.out.println("Invalid hex digit");
    }
    else {
      int intValue = Integer.parseInt(hex, 16);
      System.out.println(Integer.toBinaryString(intValue));
    }
  }
  
}
