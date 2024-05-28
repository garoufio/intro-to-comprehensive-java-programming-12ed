package chapter3;

import java.util.Scanner;

/**
 * Game: heads or tails.
 */
public class Exercise3_14 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int randomNumber = (int)(Math.random() + 0.5);
    int answer;
    
    System.out.print("Head or tails (1: head, 0: tails)? ");
    answer = input.nextInt();
    input.close();
    if (answer < 0 || answer > 1) {
      System.out.println("Invalid choice");
      System.exit(1);
    }
    
    if (answer == randomNumber) {
      System.out.println("You are correct!");
    }
    else {
      System.out.println("You are not correct!");
    }
    
  }
  
}