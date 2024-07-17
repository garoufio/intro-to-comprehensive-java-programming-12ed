package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter an integer in the range [1, 15], and it displays a pyramid.
 */
public class Exercise5_17 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number;
    
    System.out.print("Enter an integer number between 1 and 15: ");
    number = input.nextInt();
    input.close();
    if (number < 1 || number > 15) {
      System.out.println("Invalid number");
      System.exit(1);
    }
    
    for (int row = 1; row <= number; row++) {
      // print numbers to the left side
      for (int left = number; left > 1; left--) {
        if (left <= row) {
          System.out.printf("%d", left);
        }
        else {
          System.out.printf(" ");
        }
        System.out.print(" ");
      }
      // print numbers to the right side
      for (int right = 1; right <= number; right++) {
        if (right <= row) {
          System.out.print(right);
        }
        else {
          break;
        }
        if (right < number) System.out.print(" ");
      }
      System.out.println();
    }
  }
  
}
