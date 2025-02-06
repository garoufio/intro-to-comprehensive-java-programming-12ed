package chapter5;

import java.util.Scanner;

/**
 *  Prompts the user to enter a decimal integer and then displays its corresponding binary value. Don’t use Java’s
 *  Integer.toBinaryString(int) in this program.
 */
public class Exercise5_37 {
  
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
      sb.append(value % 2);
      value /= 2;
    } while (value != 0);
    
    System.out.printf("The binary representation of '%d' is '%s'\n", decimalValue, sb.reverse().toString());
  }
  
}
