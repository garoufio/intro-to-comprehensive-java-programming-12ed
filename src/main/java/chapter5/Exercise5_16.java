package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter an integer, and then it finds all the smallest factors of that integer and displays them in
 * an increasing order.
 */
public class Exercise5_16 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number;
    
    System.out.print("Enter an integer: ");
    number = input.nextInt();
    input.close();
    
    if (number < 0) {
      number = Math.abs(number);
    }
    else if (number == 0) {
      System.out.println("The number must not be equal to zero");
      System.exit(1);
    };
    
    boolean isFactorFound;
    do {
      isFactorFound = false;
      for (int i = 2; i <= number; i++) {
        if (number % i == 0) {
          System.out.println(i);
          number /= i;
          isFactorFound = true;
          break;
        }
      }
    } while (isFactorFound);
    
  }

}
