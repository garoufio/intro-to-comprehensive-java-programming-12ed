package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter two strings and displays the largest common prefix of the two strings.
 */
public class Exercise5_51 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter first string: ");
    String str1 = input.nextLine();
    System.out.print("Enter second string: ");
    String str2 = input.nextLine();
    input.close();
    
    int index = 0;
    int len = str1.length() < str2.length() ? str1.length() : str2.length();
    for (int i = 0; i < len; i++, index++) {
      if (str1.charAt(i) != str2.charAt(i)) break;
    }
    
    if (index > 0) {
      System.out.printf("The common prefix is '%s'\n", str1.substring(0, index).trim());
    }
    else {
      System.out.println("There is no common prefix between the input strings");
    }
  }
  
}
