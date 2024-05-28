package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter four points of two lines in a two coordinate system, and then it finds the intersecting
 * point, if it exists, between these lines. The Cramer's law is being user in order to solve the linear equations for
 * finding the intersecting point.
 */
public class Exercise3_25 {
  
  public static final double EPSILON = 1E-14;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4;
    
    System.out.print("Enter points x1, y1, x2, y2, x3, y3, x4, y4: ");
    pointX1 = input.nextDouble();
    pointY1 = input.nextDouble();
    pointX2 = input.nextDouble();
    pointY2 = input.nextDouble();
    pointX3 = input.nextDouble();
    pointY3 = input.nextDouble();
    pointX4 = input.nextDouble();
    pointY4 = input.nextDouble();
    input.close();
    
    double a = pointY1 - pointY2;
    double b = pointX1 - pointX2;
    double c = pointY3 - pointY4;
    double d = pointX3 - pointX4;
    double e = (a * pointX1) - (b * pointY1);
    double f = (c * pointX3) - (d * pointY3);
    double divisor = (a * d) - (b * c);
    if (Math.abs(divisor) < EPSILON) {
      System.out.println("The two lines are parallel");
    }
    else {
      double x = ((e * d) - (b * f)) / divisor;
      double y = ((a * f) - (e * c)) / divisor;
      System.out.printf("The intersecting point is at (%f, %f)\n", x, y);
    }
    
  }
  
}
