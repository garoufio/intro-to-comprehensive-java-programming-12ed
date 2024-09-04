package chapter6;

import java.util.Scanner;

public class Exercise6_19 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double readSide(Scanner scanner, int count) {
    double side;
    do {
      System.out.printf("Enter side%d: ", count);
      side = scanner.nextDouble();
      
      if (side <= 0) System.out.println("Side must be greater than 0");
    } while (side <= 0);
    
    return side;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  // Returns true if the sum of every two sides is greater than the third side
  public static boolean isValid(double side1, double side2, double side3) {
    return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double area(double side1, double side2, double side3) {
    double semiPerimeter = (side1 + side2 + side3) / 2;
    
    return Math.pow(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3), 0.5);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double side1 = readSide(scanner, 1);
    double side2 = readSide(scanner, 2);
    double side3 = readSide(scanner, 3);
    scanner.close();
    
    if (!isValid(side1, side2, side3)) {
      System.out.println("Invalid sides");
      System.exit(-1);
    }
    
    System.out.printf("The area of the triangle is '%.2f'", area(side1, side2, side3));
  }

}
