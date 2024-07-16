package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter two integers, and then returns the greatest common divisor of these integers. The
 * algorithm for computing the gcd is the following:
 * 1) find d to be the minimum of n1 and n2
 * 2) check whether d, d-1, d-2, ..., 2, 1 is a divisor of both n1 and n2 in this order
 * 3) the first such common divisor is the greatest common divisor for n1 and n2
 */
public class Exercise5_14 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number1, number2;
    
    System.out.print("Enter two integers: ");
    number1 = input.nextInt();
    number2 = input.nextInt();
    input.close();
    
    int gcd = -1;
    int min = number1 <= number2 ? number1 : number2;
    for (int i = min; i > 0; i--) {
      if (number1 % i == 0 && number2 % i == 0) {
        gcd = i;
        break;
      }
    }
    if (gcd == -1) {
      System.out.println("Greatest common divisor not found");
    }
    else {
      System.out.printf("The greatest common divisor is '%d'\n", gcd);
    }
  }
  
}
