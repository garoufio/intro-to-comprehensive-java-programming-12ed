package chapter5;

import java.util.Scanner;

/**
 * This program lets the user continuously play the scissor–rock–paper game until either the user or the computer wins
 * more than two times than its opponent.
 */
public class Exercise5_34 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number, winsCount = 0;
    
    while (true) {
      System.out.print("scissor (0), rock (1), paper (2): ");
      number = input.nextInt();
      
      if (number < 0 || number > 3) {
        System.out.println("Invalid choice");
        input.close();
        System.exit(1);
      }
      
      int randomNumber = (int) (Math.random() * 3);
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
      } else if (number == 0) {
        if (randomNumber == 1) {
          System.out.printf("The computer is '%s', You are '%s'. You lost\n", randomNumberDescription, numberDescription);
          winsCount--;
        } else {
          System.out.printf("The computer is '%s', You are '%s'. You won\n", randomNumberDescription, numberDescription);
          winsCount++;
        }
      } else if (number == 1) {
        if (randomNumber == 0) {
          System.out.printf("The computer is '%s', You are '%s'. You won\n", randomNumberDescription, numberDescription);
          winsCount++;
        } else {
          System.out.printf("The computer is '%s', You are '%s'. You lost\n", randomNumberDescription, numberDescription);
          winsCount--;
        }
      } else if (number == 2) {
        if (randomNumber == 1) {
          System.out.printf("The computer is '%s', You are '%s'. You won\n", randomNumberDescription, numberDescription);
          winsCount++;
        } else {
          System.out.printf("The computer is '%s', You are '%s'. You lost\n", randomNumberDescription, numberDescription);
          winsCount--;
        }
      }
      
      if (winsCount >= 2 || winsCount <= -2) break;
    }
    if (winsCount >= 2) {
      System.out.println("Congratulations, you won more than two times!");
    }
    else {
      System.out.println("Game over! You lost more than two times!");
    }
    input.close();
  }
  
}