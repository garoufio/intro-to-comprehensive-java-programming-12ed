package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter a 3-digit integer and checks if that number is a palindrome or not.
 */
public class Exercise3_12 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number;
    
    System.out.print("Enter a 3-digit number: ");
    number = input.nextInt();
    input.close();
    if (Math.abs(number) < 100 || Math.abs(number) > 999) {
      System.out.println("Invalid number");
      System.exit(1);
    }
    
    boolean isPalindrome = number / 100 == number % 10;
    System.out.printf("'%d' is %sa palindrome\n", number, isPalindrome ? "" : "not ");
  }

}