package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter an unspecified number of integers. Then it counts the number of positive and negative
 * numbers and computes the sum and the average of these numbers and finally it displays the results.
 */
public class Exercise5_1 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number, sum, positiveNumbersCount, negativeNumbersCount;
    double average;
    
    sum = 0;
    positiveNumbersCount = 0;
    negativeNumbersCount = 0;
    while (true) {
      System.out.print("Enter an integer, the input ends if it is 0: ");
      number = input.nextInt();
      
      if (number == 0) break;
      else if (number > 0) positiveNumbersCount++;
      else negativeNumbersCount++;
      
      sum += number;
    }
    input.close();
    int totalNumers = positiveNumbersCount + negativeNumbersCount;
    if (totalNumers > 0) {
      average = (double)sum / totalNumers;
      System.out.printf("The number of positives is '%d'\n", positiveNumbersCount);
      System.out.printf("The number of negatives is '%d'\n", negativeNumbersCount);
      System.out.printf("The total is '%d'\n", sum);
      System.out.printf("The average is '%.2f'\n", average);
    }
    else {
      System.out.println("No numbers entered except 0");
    }
    
  }
  
}
