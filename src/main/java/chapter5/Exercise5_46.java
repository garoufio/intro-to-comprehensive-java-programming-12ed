package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter a string and displays the string in reverse order.
 */
public class Exercise5_46 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String str;
    
    System.out.print("Enter a string: ");
    str = input.nextLine();
    input.close();
    
    StringBuilder sb = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      sb.append(str.charAt(i));
    }
    System.out.println("The reversed string is: " + sb.toString());
  }
  
}
