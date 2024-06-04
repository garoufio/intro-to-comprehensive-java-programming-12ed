package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter two strings, and then reports whether the second string is a substring of the first string.
 */
public class Exercise4_22 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter string s1: ");
    String str1 = input.nextLine();
    System.out.print("Enter string s2: ");
    String str2 = input.nextLine();
    
    if (str1.contains(str2)) {
      System.out.printf("'%s' is a substring of '%s'\n", str2, str1);
    }
    else {
      System.out.printf("'%s' is not a substring of '%s'\n", str2, str1);
    }
  }
  
}
