package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter two characters and displays the major and status represented in the characters. The first
 * character indicates the major and the second is a number character 1, 2, 3 or 4, which indicates whether a student
 * is a freshman, sophomore, junior or senior. The following characters are used to indicate the majors:
 * M: Mathematics
 * C: Computer Science
 * I: Information Technology
 */
public class Exercise4_18 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter two characters: ");
    String str = input.nextLine();
    input.close();
    
    if (str.length() != 2) {
      System.out.println("Invalid input length");
      System.exit(1);
    }
    
    String major = switch (str.charAt(0)) {
      case 'M' -> "Mathematics";
      case 'C' -> "Computer Science";
      case 'I' -> "Information Technology";
      default -> "Unknown";
    };
    
    String status = switch (str.charAt(1)) {
      case '1' -> "Freshman";
      case '2' -> "Sophomore";
      case '3' -> "Junior";
      case '4' -> "Senior";
      default -> "Unknown";
    };
    
    if (major.equals("Unknown") || status.equals("Unknown")) {
      System.out.println("Invalid input");
    }
    else {
      System.out.printf("%s %s\n", major, status);
    }
  }
  
}
