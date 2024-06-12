package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter a positive integer or 0, and converts it to its hexadecimal representation.
 */
public class Decimal2Hex {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int quotient, remainder;
    StringBuilder hex;
    
    System.out.print("Enter an positive integer: ");
    int number = input.nextInt();
    input.close();
    if (number < 0) {
      System.out.println("Invalid number");
      System.exit(1);
    }
    
    quotient = number;
    hex = new StringBuilder("");
    if (quotient == 0) {
      hex.append("0");
    }
    else {
      while (quotient != 0) {
        remainder = quotient % 16;
        hex.append(switch (remainder) {
          case 10 -> 'A';
          case 11 -> 'B';
          case 12 -> 'C';
          case 13 -> 'D';
          case 14 -> 'E';
          case 15 -> 'F';
          default -> remainder + "";
        });
        quotient /= 16;
      }
    }
    System.out.printf("The hex value of '%d' is '%s'", number, hex.reverse());
  }
  
}
