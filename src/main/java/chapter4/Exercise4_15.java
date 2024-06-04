package chapter4;

import java.util.Scanner;

/**
 * Phone key pads: Prompts the user to enter a lowercase or an uppercase letter, and it displays its corresponding
 * number.
 */
public class Exercise4_15 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a letter: ");
    String str = input.next();
    input.close();
    
    if (str.length() != 1) {
      System.out.println("Invalid input");
      System.exit(1);
    }
    
    char letter = str.charAt(0);
    int number = switch (Character.toUpperCase(letter)) {
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
    
    if (number > 1) {
      System.out.printf("The corresponding number is '%d'", number);
    }
  }
  
}
