package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter a positive double value and the program approximates and displays the square root of the
 * value.
 */
public class Exercise6_22 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double readNumber(Scanner scanner) {
    double number;
    
    do {
      System.out.print("Enter a positive number: ");
      number = scanner.nextDouble();
      
      if (number <= 0) System.out.println("Number must be greater than 0");
    } while (number <= 0);
    
    return number;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double sqrt(double n) {
    double lastGuess;
    double nextGuess = 1.0;
    
    do {
      lastGuess = nextGuess;
      nextGuess = (lastGuess + (n / lastGuess)) / 2;
      
    } while (!(nextGuess - lastGuess < 0.00001));
    
    return nextGuess;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double number = readNumber(scanner);
    scanner.close();

    System.out.printf("The approximate square root of '%.2f' is '%.2f'\n", number, sqrt(number));
  }
  
}
