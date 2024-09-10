package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter the side of a pentagon, and computes and displays its area.
 */
public class Exercise6_35 {
  
  public static double area(double side) {
    return (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.toRadians(180 / 5)));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double getSide(Scanner scanner) {
    double side = 0.0;
    do {
      System.out.print("Enter side length (greater than 0): ");
      side = scanner.nextDouble();
      
      if (side <= 0) System.out.printf("Invalid side len '%f'\n", side);
    } while (side <= 0);
    
    return side;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double side = getSide(input);
    input.close();
    
    System.out.printf("The area of the pentagon is '%f'\n", area(side));
  }
  
}
