package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter a string, and then it checks whether thar string is a palindrome or not.
 */
public class Palindrome {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a string: ");
    String str = input.nextLine();
    input.close();
    
    int len = str.length();
    boolean isPalindrome = true;
    for (int i= 0, j = len - 1; i < j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        isPalindrome = false;
        break;
      }
    }
    System.out.printf("The string is a palindrome: %b\n", isPalindrome);
  }
  
}
