package chapter6;

import java.util.Scanner;

/**
 * Converts a hexadecimal value to a decimal value.
 */
public class Hex2Decimal {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a hexadecimal number: ");
    String hex = input.nextLine().trim().toUpperCase();
    input.close();
    
    if (!isValidHex(hex)) {
      System.out.printf("Invalid hexadecimal number '%s'\n", hex);
    }
    else {
      int decimal = convertHex2Decimal(hex);
      System.out.printf("The decimal number is '%d'\n", decimal);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int convertHex2Decimal(String hex) {
    int decimal = 0;
    int len = hex.length();
    
    for (int i = len -1, j = 0; i >= 0; i--, j++) {
      decimal  += (int)Math.pow(16, i) * convertHexChar2Decimal(hex.charAt(j));
    }
    
    return decimal;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int convertHexChar2Decimal(char ch) {
    if (ch >= 'A' &&  ch <= 'F') {
      return 10 + ch - 'A';
    }
    else {
      return ch - '0';
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidHex(String hex) {
    for (int i = 0; i < hex.length(); i++) {
      char ch = hex.charAt(i);
      if (!((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F'))) return false;
    }
    
    return true;
  }
  
}
