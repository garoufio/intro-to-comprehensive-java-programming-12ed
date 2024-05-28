package chapter3;

import java.util.Scanner;

/**
 * Addition quiz
 */
public class Exercise3_10 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number1 = (int)(Math.random() * 100);
    int number2 = (int)(Math.random() * 100);
    int answer;
    
    System.out.printf("What is %d + %d? ", number1, number2);
    answer = input.nextInt();
    input.close();
    
    if (number1 + number2 == answer) {
      System.out.println("You are correct!");
    }
    else {
      System.out.printf("Wrong. The correct answer is '%d'\n", number1 + number2);
    }
  }
  
}
