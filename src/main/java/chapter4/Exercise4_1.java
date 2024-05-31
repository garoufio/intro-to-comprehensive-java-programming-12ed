package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter the length from the center of a pentagon to a vertex, and computes the area of the
 * pentagon.
 */
public class Exercise4_1 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the length from the center to a vertex: ");
    double len = input.nextDouble();
    input.close();
    if (len < 0) {
      System.out.println("Invalid length");
      System.exit(1);
    }
    
    double side = 2 * len * Math.sin(Math.toRadians(180 / 5));
    double area = (5 * side * side) / (4 * (Math.tan(Math.toRadians(180 / 5))));
    System.out.printf("The area of the pentagon is '%f'\n", area);
  }
  
}
