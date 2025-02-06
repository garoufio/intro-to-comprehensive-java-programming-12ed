package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter a decimal integer and displays its corresponding octal value. Don’t use Java’s
 * Integer.toOctalString(int) in this program.
 */
public class Exercise5_38 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int decimalValue;
    
    System.out.print("Enter the decimal value: ");
    decimalValue = input.nextInt();
    input.close();
    
    if (decimalValue < 0) decimalValue = -decimalValue;
    
    StringBuilder sb = new StringBuilder();
    int value = decimalValue;
    do {
      sb.append(value % 8);
      value /= 8;
    } while (value != 0);
    
    System.out.printf("The octal representation of '%d' is '%s'\n", decimalValue, sb.reverse().toString());
  }

}
