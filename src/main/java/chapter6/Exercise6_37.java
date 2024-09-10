package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter a number and its width, and then displays a string which contains that number formatted by
 * the given width.
 */
public class Exercise6_37 {
  
  public static String format(int number, int width) {
    String str;
    String numberStr = String.valueOf(number);
    int len = numberStr.length();
    
    if (width > len) {
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < width - len; i++) {
        stringBuilder.append(" ");
      }
      str = numberStr + stringBuilder.toString();
    }
    else if (width < len) {
      str = numberStr.substring(0, width);
    }
    else {
      str = numberStr;
    }
    
    return str;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getWidth(Scanner scanner) {
    int width;
    
    do {
      System.out.print("Enter width (greater than 0): ");
      width = scanner.nextInt();
      
      if (width <= 0) System.out.printf("Invalid width '%d'\n", width);
    } while (width <= 0);
    
    return width;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getNumber(Scanner scanner) {
    System.out.print("Enter number: ");
    return scanner.nextInt();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number = getNumber(input);
    int width = getWidth(input);
    input.close();
    
    System.out.printf("Formatted number '%s'\n", format(number, width));
  }
  
}
