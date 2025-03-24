package chapter8;

import java.util.Scanner;

/**
 * (Geometry: intersecting point) The program returns the intersecting point of two lines. The intersecting point of
 * the two lines can be found by using the formula given in Programming Exercise 3.25. Assume that (x1, y1) and (x2, y2)
 * are the two points on line 1 and (x3, y3) and (x4, y4) are on line 2. The points are stored in a 4-by-2
 * two-dimensional array points with (points[0][0], points[0][1]) for (x1, y1). The method returns the intersecting
 * point or null if the two lines are parallel. The program that prompts the user to enter four points and displays the
 * intersecting point.
 */
public class Exercise8_31 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      double[][] points = readPoints(sc);
      double[] intersectingPoint = getIntersectingPoint(points);
      
      if (intersectingPoint == null) {
        System.out.println("The two lines are parallel");
      }
      else {
        System.out.println("");
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[] getIntersectingPoint(double[][] points) {
    double[] intersectingPoint = new double[2];
    
    double a = points[0][1] - points[1][1]; // pointY1 - pointY2;
    double b = points[0][0] - points[1][0]; // pointX1 - pointX2;
    double c = points[2][1] - points[3][1]; // pointY3 - pointY4;
    double d = points[2][0] - points[3][0]; // pointX3 - pointX4;
    double e =  (a * points[0][0]) - (b * points[0][1]); // (a * pointX1) - (b * pointY1);
    double f = (c * points[2][0]) - (d * points[2][1]); // (c * pointX3) - (d * pointY3);
    double divisor = (a * d) - (b * c);
    if (Math.abs(divisor) < 0.0001) {
      return null;
    }
    else {
      double x = ((e * d) - (b * f)) / divisor;
      double y = ((a * f) - (e * c)) / divisor;
      System.out.printf("The intersecting point is at (%f, %f)\n", x, y);
    }
    return intersectingPoint;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readPoints(Scanner sc) {
    double[][] points = new double[4][2];
    
    System.out.print("Enter x and y coordinates of 4 points: ");
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 2; j++) {
        points[i][j] = sc.nextDouble();
      }
    }
    return points;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
