package chapter4;

import java.util.Scanner;

public class Exercise4_14 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a letter grade: ");
    char letter = input.next().charAt(0);
    input.close();
    
    int grade = switch(Character.toUpperCase(letter)) {
      case 'A' -> 4;
      case 'B' -> 3;
      case 'C' -> 2;
      case 'D' -> 1;
      case 'F' -> 0;
      default -> throw new IllegalArgumentException(letter + " is an invalid grade");
    };
    System.out.printf("The numeric value for grade '%c' is '%d'\n", letter, grade);
  }
  
}
