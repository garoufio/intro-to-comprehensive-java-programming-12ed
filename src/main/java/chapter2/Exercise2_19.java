package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the area of a triangle according to the Heron's formula. The coordinates of the three points
 * are given by the user.
 */
public class Exercise2_19 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, area, semiPerimeter, side1, side2, side3;
    
    System.out.print("Enter the coordindates of three points separated by spaces like x1 y1 x2 y2 x3 y3: ");
    pointX1 = input.nextDouble();
    pointY1 = input.nextDouble();
    pointX2 = input.nextDouble();
    pointY2 = input.nextDouble();
    pointX3 = input.nextDouble();
    pointY3 = input.nextDouble();
    input.close();
    
    side1 = Math.pow(Math.pow(pointX2 - pointX1, 2) + Math.pow(pointY2 - pointY1, 2), 0.5);
    side2 = Math.pow(Math.pow(pointX3 - pointX2, 2) + Math.pow(pointY3 - pointY2, 2), 0.5);
    side3 = Math.pow(Math.pow(pointX3 - pointX1, 2) + Math.pow(pointY3 - pointY1, 2), 0.5);
    semiPerimeter = (side1 + side2 + side3) / 2;
    area = Math.pow(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3), 0.5);
    System.out.printf("The area of the triangle is '%.2f'\n", area);
  }
  
}
