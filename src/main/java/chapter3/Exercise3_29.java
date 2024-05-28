package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter the center and the radius of two circles, and then determines whether the second circle
 * is inside the first or overlaps with the first.
 */
public class Exercise3_29 {
  
  public static final double EPSILON = 1E-14;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double centerX1, centerY1, radius1, centerX2, centerY2, radius2;
    
    System.out.print("Enter circle1's center x-, y- coordinates, and radius: ");
    centerX1 = input.nextDouble();
    centerY1 = input.nextDouble();
    radius1 = input.nextDouble();
    System.out.print("Enter circle2's center x-, y- coordinates, and radius: ");
    centerX2 = input.nextDouble();
    centerY2 = input.nextDouble();
    radius2 = input.nextDouble();
    input.close();
    
    double distance = Math.sqrt(Math.pow(centerX2 - centerX1, 2) + Math.pow(centerY2 - centerY1, 2));
    if (distance - (radius1 - radius2) <= EPSILON) {
      System.out.println("Circle2 is inside circle1");
    }
    else if (distance - (radius2 + radius1) <= EPSILON) {
      System.out.println("Circle2 overlaps circle1");
    }
    else {
      System.out.println("Circle2 does not overlap circle1");
    }
    
  }

}
