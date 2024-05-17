package chapter2;

import java.util.Scanner;

/**
 * Calculates the sum of the digits of a given integer number and displays the result.
 */
public class Exercise2_6 {
  
  public static final int UPPER_LIMIT = 1000;
  public static final int LOWER_LIMIT = 0;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number;
    
    System.out.print("Enter an integer number between 0 and 1000: ");
    number = input.nextInt();
    input.close();
    
    if (number < LOWER_LIMIT || number > UPPER_LIMIT) {
      System.out.printf("Number is out of range [%d, %d]\n", LOWER_LIMIT, UPPER_LIMIT);
    } else {
      int remainingNumber = number;
      int sum = 0;
      
      while (remainingNumber != 0) {
        sum += remainingNumber % 10;
        remainingNumber /= 10;
      }
      
      System.out.printf("The sum of the digits of number '%d' is '%d'\n", number, sum);
    }
  }
  
}
