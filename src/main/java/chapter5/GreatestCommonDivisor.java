package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter two integers, and then returns the greatest common divisor of these integers.
 */
public class GreatestCommonDivisor {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the first integer: ");
    int number1 = input.nextInt();
    System.out.print("Enter the second integer: ");
    int number2 = input.nextInt();
    input.close();
    
    int gcd = 1;
    int k = gcd;
    while (k <= number1 && k <= number2) {
      if (number1 % k == 0 && number2 % k == 0) {
        gcd = k;
      }
      k++;
    }
    System.out.printf("The greatest common divisor for '%d' and '%d' is '%d'\n", number1, number2, gcd);
  }
  
}
