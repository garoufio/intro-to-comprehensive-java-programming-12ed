package chapter6;

import java.util.Scanner;

/**
 * Computes and displays an integer in reverse order.
 */
public class Exercise6_4 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter an integer number: ");
    int number = input.nextInt();
    input.close();
    reverse(number);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void reverse(int number) {
    int sum = 0;
    boolean isNegative = number < 0;
    int n = isNegative ? -number : number;
    
    while (n != 0) {
      sum = sum * 10 + n % 10;
      n /= 10;
    }
    
    System.out.printf("The reverse of '%d' is '%d'\n", number, sum);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
