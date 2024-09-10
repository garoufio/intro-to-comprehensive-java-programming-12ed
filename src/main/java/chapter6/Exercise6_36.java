package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter the number of sides and the side length of a pentagon, and computes and displays its area.
 */
public class Exercise6_36 {
  
  public static double area(int numberOfSides, double side) {
    return (numberOfSides * Math.pow(side, 2)) / (4 * Math.tan(Math.toRadians(180 / numberOfSides)));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getNumberOfSides(Scanner scanner) {
    int numberOfSides;
    
    do {
      System.out.print("Enter the number of sides (greater than 0): ");
      numberOfSides = scanner.nextInt();
      
      if (numberOfSides <= 0) System.out.printf("Invalid number of sides '%d'\n", numberOfSides);
    } while (numberOfSides <= 0);
    
    return numberOfSides;
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
    int numberOfSides = getNumberOfSides(input);
    double side = getSide(input);
    input.close();
    
    System.out.printf("The area of the polygon is '%f'\n", area(numberOfSides, side));
  }
  
}
