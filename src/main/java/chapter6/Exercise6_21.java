package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter a phone number as a string. The program translates a letter (uppercase or lowercase) to a
 * digit and leaves all other characters intact.
 */
public class Exercise6_21 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int convertLetterToDigit(char letter) {
    return switch (Character.toUpperCase(letter)) {
      case 'A', 'B', 'C' -> 2;
      case 'D', 'E', 'F' -> 3;
      case 'G', 'H', 'I' -> 4;
      case 'J', 'K', 'L' -> 5;
      case 'M', 'N', 'O' -> 6;
      case 'P', 'Q', 'R', 'S' -> 7;
      case 'T', 'U', 'V' -> 8;
      case 'W', 'X', 'Y', 'Z' -> 9;
      default -> {
        System.out.println("Invalid input");
        yield -1;
      }
    };
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String readPhoneNumber(Scanner scanner) {
    System.out.print("Enter a string: ");
    return scanner.nextLine();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String phoneNumber = readPhoneNumber(scanner);
    scanner.close();
    
    StringBuilder builder = new StringBuilder();
    for (char ch : phoneNumber.toCharArray()) {
      if (Character.isLetter(ch)) {
        builder.append(convertLetterToDigit(ch));
      }
      else {
        builder.append(ch);
      }
    }
    System.out.println(builder);
  }
  
}
