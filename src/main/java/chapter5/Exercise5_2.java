package chapter5;

import java.util.Scanner;

/**
 * Generates 10 random addition questions for two integers between 1 and 15 and prompts the user to enter his/her
 * answer.
 */
public class Exercise5_2 {
  
  public static final int NUMBER_OF_REPEATS = 10;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number1, number2, result, answer, correctAnswersCount = 0;
    long startTime = System.currentTimeMillis();
    
    for (int i = 0; i < NUMBER_OF_REPEATS; i++) {
      number1 = (int)((Math.random() * 15) + 1);
      number2 = (int)((Math.random() * 15) + 1);
      result = number1 + number2;
      System.out.printf("%d/%d. What is the result of %d + %d? ", i + 1, NUMBER_OF_REPEATS, number1, number2);
      answer = input.nextInt();
      
      if (answer == result) {
        System.out.println("You are correct!");
        correctAnswersCount++;
      }
      else {
        System.out.printf("Wrong! The correct result is '%d'\n", result);
      }
    }
    long endTime = System.currentTimeMillis();
    System.out.printf("You answered correctly in %d/%d\n", correctAnswersCount, NUMBER_OF_REPEATS);
    System.out.printf("Elapsed time: %d seconds\n", (endTime - startTime) / 1000);
  }
  
}
