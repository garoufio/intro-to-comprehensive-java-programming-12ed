package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter a Social Security number in the format DDD-DD-DDDD, and checks whether the input is valid
 * or not.
 */
public class Exercise4_21 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a SSN: ");
    String ssn = input.nextLine();
    input.close();
    
    boolean isValid = true;
    if (ssn.length() != 11) {
      isValid = false;
    }
    
    if (!Character.isDigit(ssn.charAt(0))) {
      isValid = false;
    }
    if (isValid && !Character.isDigit(ssn.charAt(1))) {
      isValid = false;
    }
    if (isValid && !Character.isDigit(ssn.charAt(2))) {
      isValid = false;
    }
    if (isValid && (ssn.charAt(3) != '-' || ssn.charAt(6) != '-')) {
      isValid = false;
    }
    if (isValid && !Character.isDigit(ssn.charAt(4))) {
      isValid = false;
    }
    if (isValid && !Character.isDigit(ssn.charAt(5))) {
      isValid = false;
    }
    if (isValid && !Character.isDigit(ssn.charAt(7))) {
      isValid = false;
    }
    if (isValid && !Character.isDigit(ssn.charAt(8))) {
      isValid = false;
    }
    if (isValid && !Character.isDigit(ssn.charAt(9))) {
      isValid = false;
    }
    if (isValid && !Character.isDigit(ssn.charAt(10))) {
      isValid = false;
    }

    if (isValid) {
      System.out.printf("'%s' is a valid social security number\n", ssn);
    }
    else {
      System.out.printf("'%s' is an invalid social security number\n", ssn);
    }
  }
  
}
