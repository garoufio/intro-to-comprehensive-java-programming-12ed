package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter an integer number, and it checks if that number:
 * 1. is divisible by 5 and 6
 * 2. divisible by 5 or 6
 * 3. divisible by 5 or 6 but not both
 */
public class Exercise3_26 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int intVal;
    
    System.out.print("Enter an integer: ");
    intVal = input.nextInt();
    input.close();
    
    System.out.printf("Is '%d' divisible by 5 and 6? %b\n", intVal, (intVal % 5 == 0 && intVal % 6 == 0));
    System.out.printf("Is '%d' divisible by 5 or 6? %b\n", intVal, (intVal % 5 == 0 || intVal % 6 == 0));
    System.out.printf("Is '%d' divisible by 5 or 6, but not both? %b\n", intVal, (intVal % 5 == 0 ^ intVal % 6 == 0));
  }
  
}
