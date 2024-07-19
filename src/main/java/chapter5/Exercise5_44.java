package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter a short integer and displays the 16 bits for the integer.
 */
public class Exercise5_44 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.printf("Enter a short integer [%d, %d]: ", Short.MIN_VALUE, Short.MAX_VALUE);
    short number = input.nextShort();
    input.close();
    
    if (number < Short.MIN_VALUE || number > Short.MAX_VALUE) {
      System.out.println("Invalid short integer");
      System.exit(1);
    }
    
    StringBuilder sb = new StringBuilder();
    short bit;
    do {
      bit = (short) (number % 2);
      sb.append(bit);
      number /= 2;
    } while (number != 0);
    System.out.printf("The bits are '%016d'\n", Short.parseShort(sb.reverse().toString()));
    
  }
  
}
