package chapter3;

import java.util.Scanner;

public class Exercise3_17 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number;
    
    System.out.print("scissor (0), rock (1), paper (2): ");
    number = input.nextInt();
    input.close();
    
    if (number < 0 || number > 3) {
      System.out.println("Invalid choice");
      System.exit(1);
    }
    
    int randomNumber = (int)(Math.random() * 3);
    String numberDescription, randomNumberDescription;
    
    numberDescription = switch (number) {
      case 0 -> "scissor";
      case 1 -> "rock";
      case 2 -> "paper";
      default -> "unknown";
    };
    randomNumberDescription = switch (randomNumber) {
      case 0 -> "scissor";
      case 1 -> "rock";
      case 2 -> "paper";
      default -> "unknown";
    };
    
    if (number == randomNumber) {
      System.out.printf(
          "The computer is '%s', You are '%s' too. It is a draw.\n",
          randomNumberDescription, numberDescription
      );
    }
    else if (number == 0) {
      if (randomNumber == 1) {
        System.out.printf("The computer is '%s', You are '%s'. You lost\n", randomNumberDescription, numberDescription);
      }
      else {
        System.out.printf("The computer is '%s', You are '%s'. You won\n", randomNumberDescription, numberDescription);
      }
    }
    else if (number == 1) {
      if (randomNumber == 0) {
        System.out.printf("The computer is '%s', You are '%s'. You won\n", randomNumberDescription, numberDescription);
      }
      else {
        System.out.printf("The computer is '%s', You are '%s'. You lost\n", randomNumberDescription, numberDescription);
      }
    }
    else if (number == 2) {
      if (randomNumber == 1) {
        System.out.printf("The computer is '%s', You are '%s'. You won\n", randomNumberDescription, numberDescription);
      }
      else {
        System.out.printf("The computer is '%s', You are '%s'. You lost\n", randomNumberDescription, numberDescription);
      }
    }
  }
  
}
