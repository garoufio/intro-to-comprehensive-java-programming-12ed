package chapter4;

import java.util.Scanner;

/**
 *
 */
public class Exercise4_13 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a letter: ");
    String str = input.next();
    input.close();
    
    if (str.length() != 1) {
      System.out.println("Invalid input");
      System.exit(1);
    }
    
    char letter = Character.toUpperCase(str.charAt(0));
    if (letter >= 'A' && letter <= 'Z') {
      String msg = switch (letter) {
        case 'A',  'E', 'I', 'O', 'U' -> "vowel";
        default -> "consonant";
      };
      System.out.printf("'%s' is a %s\n", str, msg);
    }
    else {
      System.out.printf("'%s' is an invalid input\n", str);
    }
  }
  
}
