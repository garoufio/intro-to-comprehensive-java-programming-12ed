package chapter5;

import java.util.Scanner;

/**
 * A cancellation error occurs when you are manipulating a very large number with a very small number. The large number
 * may cancel out the smaller number. For example, the result of 100000000.0 * + 0.000000001 is equal to 100000000.0.
 * To avoid cancellation errors and obtain more accurate results, carefully select the order of computation. For
 * example, in computing the following summation, you will obtain more accurate results by computing from right to left
 * rather than from left to right: 1 + 1 / 2 + 1 / 3 + ... + 1 / n.
 * The program prompts the user to enter a positive integer greater than 10000, and it compares the results of the
 * summation of the preceding series, computing from left to right and from right to left.
 */
public class Exercise5_23 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number;
    
    System.out.print("Enter an integer greater than or equal to 10.000: ");
    number = input.nextInt();
    input.close();
    
    if (number < 10000) {
      System.out.printf("The number '%d' is less than 10000\n", number);
      System.exit(1);
    }
    
    double resultFromLeftToRight = 1;
    for (int i = 2; i <= number; i++) {
      resultFromLeftToRight += 1 / (double)i;
    }
    System.out.println("From left to right: " + resultFromLeftToRight);
    
    double resultFromRightToLeft = 1;
    for (int i = number; i > 1; i--) {
      resultFromRightToLeft += 1 / (double)i;
    }
    System.out.println("From right to left: " + resultFromRightToLeft);
  }
  
}
