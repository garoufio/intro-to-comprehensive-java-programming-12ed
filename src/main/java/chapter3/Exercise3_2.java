package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter three integer numbers and to calculate the sum of these three  integers.
 */
public class Exercise3_2 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int intVal1, intVal2, intVal3, sum, inputSum;
    
    System.out.print("Enter three integer values: ");
    intVal1 = input.nextInt();
    intVal2 = input.nextInt();
    intVal3 = input.nextInt();
    
    sum = intVal1 + intVal2 + intVal3;
    System.out.printf("What is the sum of %d + %d + %d? ", intVal1, intVal2, intVal3);
    inputSum = input.nextInt();
    input.close();
    
    if (inputSum == sum) {
      System.out.println("Correct!");
    }
    else {
      System.out.printf("Incorrect. The correct answer is '%d'\n", sum);
    }
  }
  
}
