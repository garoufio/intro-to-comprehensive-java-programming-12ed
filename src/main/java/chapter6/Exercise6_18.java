package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter a password, and it checks if it is a valid password. The password rules are as
 * follows:
 *  1) must have at least eight characters
 *  2) must contain only letters and digits
 *  3) must contain at least two digits
 */
public class Exercise6_18 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String readPassword(Scanner scanner) {
    System.out.println(
        """
            1) A password must have at least eight characters
            2) A password must must contain only letters and digits
            3) A password must have at least two digits
            Enter password: """
    );
    return scanner.nextLine();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidPassword(String password) {
    // check rule 1
    if (password.length() < 8) return false;
    
    // check rule 2
    for (char ch: password.toCharArray()) {
      if (!Character.isLetterOrDigit(ch)) return false;
    }
    // check rule 2
    int countDigits = 0;
    for (char ch: password.toCharArray()) {
      if (Character.isDigit(ch)) countDigits++;
    }
    if (countDigits < 2) return false;
    
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String password = readPassword(scanner);
    scanner.close();
    
    if (isValidPassword(password)) {
      System.out.println("Valid Password");
    }
    else {
      System.out.println("Invalid password");
    }
  }
  
}
