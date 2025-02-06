package chapter6;

import java.util.Scanner;

/**
 * Checks if an integer number is a palindrome.
 */
public class Exercise6_3 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter an integer number: ");
    int number = input.nextInt();
    input.close();
    System.out.printf("Is '%d' a palindrome? %b\n", number, isPalindrome(number));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int reverse(int number) {
    int sum = 0;
    boolean isNegative = number < 0;
    int n = isNegative ? -number : number;
    
    while (n != 0) {
      sum = sum * 10 + n % 10;
      n /= 10;
    }
    
    return isNegative ? -sum : sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isPalindrome(int number) {
    return number == reverse(number);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
