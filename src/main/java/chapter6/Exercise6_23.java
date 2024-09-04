package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter a string and a character. The program counts the occurrences of the specified character
 * in the given string.
 */
public class Exercise6_23 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static char readCharacter(Scanner scanner) {
    System.out.print("Enter a character: ");
    return scanner.next().charAt(0);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String readString(Scanner scanner) {
    System.out.print("Enter a string: ");
    return scanner.nextLine();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int count(String str, char ch) {
    int count = 0;
    
    for (char c : str.toCharArray()) {
      if (ch == c) count++;
    }
    
    return count;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = readString(scanner);
    char ch = readCharacter(scanner);
    scanner.close();
    
    System.out.println(count(str, ch));
  }
  
}
