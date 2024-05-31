package chapter4;

/**
 * Prompts the user to enter the ASCII code (integer 0-127), and then it displays its character.
 */
import java.util.Scanner;

public class Exercise4_8 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter an ASCII code: ");
    int code = input.nextInt();
    input.close();
    
    if (code < 0 || code > 127) {
      System.out.println("Invalid ASCII code");
      System.exit(1);
    }
    
    System.out.printf("The character for ASCII code is '%c'\n", (char)code);
  }
  
}
