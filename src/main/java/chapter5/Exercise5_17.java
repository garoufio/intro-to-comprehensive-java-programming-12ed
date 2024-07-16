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
    
    for (int i = 0; i < number; i++) { // rows
      for (int j = 0, right = 1; j < ((2 * number) - 1); j++) { // columns
        if (j >= number - 1) {
          System.out.print(right++);
        } else {
          System.out.print(" ");
        }
      }
      System.out.println("");
    }
  }
  
}
