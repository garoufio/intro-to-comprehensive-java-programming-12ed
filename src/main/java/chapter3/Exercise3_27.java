package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter a point with two coordinates and checks if that point is inside the triangle of which
 * points are (0, 0), (200, 0) and (0, 100). The cross product is used in order to check whether the point is in the
 * triangle.
 */
public class Exercise3_27 {
  
  public static final double POINT_X1 = 0;
  public static final double POINT_Y1 = 0;
  public static final double POINT_X2 = 0;
  public static final double POINT_Y2 = 100;
  public static final double POINT_X3 = 200;
  public static final double POINT_Y3 = 0;
  public static final double EPSILON = 1E-14;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double pointX, pointY;
    
    System.out.print("Enter a point's x- and y- coordinates: ");
    pointX = input.nextDouble();
    pointY = input.nextDouble();
    input.close();
    
    // if all cross products have the same sign, then the point is in the triangle
    // AP x AB = (pX - aX) * (bY - aY) - (bX - aX) * (pY - aY)
    double crossProduct = (pointX - POINT_X1) * (POINT_Y2 - POINT_Y1) - (POINT_X2 - POINT_X1) * (pointY - POINT_Y1);
    boolean sign1 = crossProduct >= EPSILON;
    // BP x BC = (pX - bX) * (cY - bY) - (cX - bX) * (pY - bY)
    crossProduct = (pointX - POINT_X2) * (POINT_Y3 - POINT_Y2) - (POINT_X3 - POINT_X2) * (pointY - POINT_Y2);
    boolean sign2 = crossProduct >= EPSILON;
    // CP x CA = (pX - cX) * (aY - cY) - (aX - cX) * (pY - cY)
    crossProduct = (pointX - POINT_X3) * (POINT_Y1 - POINT_Y3) - (POINT_X1 - POINT_X3) * (pointY - POINT_Y3);
    boolean sign3 = crossProduct >= EPSILON;
    
    if (sign1 && sign2 & sign3) {
      System.out.println("The point is in the triangle");
    }
    else {
      System.out.println("The point is not in the triangle");
    }
  }
  
}
