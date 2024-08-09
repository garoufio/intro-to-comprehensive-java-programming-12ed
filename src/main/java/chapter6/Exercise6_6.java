package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter an integer number and then displays a pattern.
 */
public class Exercise6_6 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter and integer number: ");
    int number = input.nextInt();
    input.close();
    
    displayPattern(number);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayPattern(int number) {
    for (int i = number; i > 0; i--) {
      for (int j = 1, k = number; j <= number; j++, k--) {
        if (j >= i) System.out.printf(" %4d", k);
        else System.out.printf("%5s", "");
      }
      System.out.println();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
