package chapter3;

import java.util.Scanner;

/**
 * Game: lottery. Generates a 3-digit random number and prompts the user to enter a 3-digit integer and determines
 * whether the user wins according to the following rules:
 * 1. If all digits match in the exact order, the award is $10,000
 * 2. If all digits match, the award is $3,000
 * 3. If one digit matches, the award is $1,000
 */
public class Exercise3_15 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number;
    
    int randomNumber = (int)(Math.random() * 900 + 100);
    System.out.print("Enter a 3-digit integer: ");
    number = input.nextInt();
    input.close();

    if (number < 100 || number > 999) {
      System.out.println("Invalid number");
      System.exit(1);
    }

    //int randomNumber = (int)(Math.random() * 900 + 100);
    int randomNumberDigit1, randomNumberDigit2, randomNumberDigit3;
    int numberDigit1, numberDigit2, numberDigit3;
    
    randomNumberDigit1 = randomNumber / 100;
    randomNumberDigit2 = (randomNumber % 100) / 10;
    randomNumberDigit3 = (randomNumber % 100) % 10;
    numberDigit1 = number / 100;
    numberDigit2 = (number % 100) / 10;
    numberDigit3 = (number % 100) % 10;
    
    if (number == randomNumber) {
      System.out.printf("Exact match with '%d'! You win $10,000\n", randomNumber);
    }
    else if (
        (randomNumberDigit1 == numberDigit1 && randomNumberDigit2 == numberDigit3 && randomNumberDigit3 == numberDigit2) ||
        (randomNumberDigit1 == numberDigit3 && randomNumberDigit2 == numberDigit2 && randomNumberDigit3 == numberDigit1) ||
        (randomNumberDigit1 == numberDigit2 && randomNumberDigit2 == numberDigit1 && randomNumberDigit3 == numberDigit3) ||
        (randomNumberDigit1 == numberDigit2 && randomNumberDigit2 == numberDigit3 && randomNumberDigit3 == numberDigit1) ||
        (randomNumberDigit1 == numberDigit3 && randomNumberDigit2 == numberDigit1 && randomNumberDigit3 == numberDigit2)
    ) {
      System.out.printf("There is a match with '%d'! You win $3,000\n", randomNumber);
    }
    else if (
        randomNumberDigit1 == numberDigit1 || randomNumberDigit1 == numberDigit2 || randomNumberDigit1 == numberDigit3 ||
        randomNumberDigit2 == numberDigit1 || randomNumberDigit2 == numberDigit2 || randomNumberDigit2 == numberDigit3 ||
        randomNumberDigit3 == numberDigit1 || randomNumberDigit3 == numberDigit2 || randomNumberDigit3 == numberDigit3
    ) {
      System.out.printf("Match one digit with '%d'! You win $1,000\n", randomNumber);
    }
    else {
      System.out.printf("No match with '%d'\n", randomNumber);
    }
  }
  
}
