package chapter5;

import java.util.Scanner;

public class GuessNumberOneTime {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int randomNumber = (int)(Math.random() * 100 + 1);
    
    System.out.println("Guess a magic number between 0 and 100");
    int number = -1;
    while (number != randomNumber) {
      System.out.print("Enter your guess: ");
      number = input.nextInt();
      if (number < randomNumber) {
        System.out.println("Your guess is too low");
      }
      else if (number > randomNumber) {
        System.out.println("Your guess is too high");
      }
    }
    System.out.printf("Yes, the number is '%d'\n", number);
  }
  
}
