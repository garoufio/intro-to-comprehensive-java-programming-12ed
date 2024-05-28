package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter the coordinates of the three edges of a triangle, and then it calculates and displays
 * the perimeter of the triangle.
 */
public class Exercise3_19 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int pointX1, pointY1, pointX2, pointY2, pointX3, pointY3;
    
    System.out.print("Enter triangle coordinates (x1 y1 x2 y2 x3 y3): ");
    pointX1 = input.nextInt();
    pointY1 = input.nextInt();
    pointX2 = input.nextInt();
    pointY2 = input.nextInt();
    pointX3 = input.nextInt();
    pointY3 = input.nextInt();
    input.close();
    
    double side1 = Math.sqrt(Math.pow(pointX2 - pointX1, 2) + Math.pow(pointY2 - pointY1, 2));
    double side2 = Math.sqrt(Math.pow(pointX3 - pointX2, 2) + Math.pow(pointY3 - pointY2, 2));
    double side3 = Math.sqrt(Math.pow(pointX3 - pointX1, 2) + Math.pow(pointY3 - pointY1, 2));
    
    if ((side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1)) {
      double perimeter = side1 + side2 + side3;
      System.out.printf("The triangle's perimeter is '%f'\n", perimeter);
    }
    else {
      System.out.println("Invalid input");
    }
  }

}
