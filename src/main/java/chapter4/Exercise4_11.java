package chapter4;

/**
 * Prompts the user to enter an integer decimal value in the range [0, 15], and then it converts that decimal value to
 * the equivalent hex value and displays it.
 */

import java.util.Scanner;

public class Exercise4_11 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a decimal value (0-15): ");
    int decimalValue = input.nextInt();
    input.close();
    
    char hexValue = switch (decimalValue) {
      case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> (char)(decimalValue + 48);
      case 10 -> 'A';
      case 11 -> 'B';
      case 12 -> 'C';
      case 13 -> 'D';
      case 14 -> 'E';
      case 15 -> 'F';
      default -> throw new IllegalStateException("Invalid decimal value: " + decimalValue);
    };
    System.out.printf("The hex value is '%c'\n", hexValue);
    // or use the built-in function of the Character class
    //System.out.printf("The hex value is '%c'\n", Character.toUpperCase(Character.forDigit(decimalValue, 16)));
  }
  
}
