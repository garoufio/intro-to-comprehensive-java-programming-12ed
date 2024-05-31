package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter the side of a hexagon, and then computes and displays its area.
 */
public class Exercise4_4 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the side of the hexagon: ");
    double side = input.nextDouble();
    input.close();
    if (side < 0) {
      System.out.println("The side of the hexagon must not be negative");
      System.exit(1);
    }
    
    double area = (6 * side * side) / (4 * Math.tan(Math.toRadians(180 / 6)));
    System.out.printf("The area of the hexagon is '%.2f'\n", area);
  }
  
}
