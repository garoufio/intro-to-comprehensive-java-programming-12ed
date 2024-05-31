package chapter4;

import java.util.Scanner;

public class HexDigitToDec {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a hexadecimal digit: ");
    String hexString = input.nextLine();
    input.close();
    
    if (hexString.length() > 1 || hexString.length() == 0) {
      System.out.println("You must enter exactly one character");
      System.exit(1);
    }
    else if (hexString.toUpperCase().charAt(0) >= 'A' || hexString.toUpperCase().charAt(0) <= 'Z') {
      byte hexValue = Byte.parseByte(hexString, 16);
      System.out.printf("The decimal value hexadecimal digit '%s' is '%d'\n", hexString, hexValue);
    }
    else if (Character.isDigit(hexString.charAt(0))) {
      System.out.printf("The decimal value hexadecimal digit '%s' is '%s'\n", hexString, hexString);
    }
    else {
      System.out.printf("Invalid input '%s'\n", hexString);
    }
  }
  
}
