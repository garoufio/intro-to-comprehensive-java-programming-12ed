package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter a point in x and y-axis, and then it checks whether that point is within a rectangle
 * centered in (0, 0) with width = 10 and height = 5.
 */
public class Exercise3_23 {
  
  public static final double RECTANGLE_WIDTH = 10;
  public static final double RECTANGLE_HEIGHT = 5;
  public static final double RECTANGLE_CENTER_POINT_X = 0;
  public static final double RECTANGLE_CENTER_POINT_Y = 0;
  public static final double EPSILON = 1E-14;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double pointX, pointY;
    
    System.out.print("Enter a point two coordinates: ");
    pointX = input.nextDouble();
    pointY = input.nextDouble();
    input.close();
    
    double distanceX = Math.sqrt(Math.pow(pointX - RECTANGLE_CENTER_POINT_X, 2));
    double distanceY = Math.sqrt(Math.pow(pointY - RECTANGLE_CENTER_POINT_Y, 2));
    System.out.printf(
        "Point '(%f, %f)' is %sin the rectangle\n",
        pointX, pointY,
        (distanceX - (RECTANGLE_WIDTH / 2.0) <= EPSILON) && (distanceY - (RECTANGLE_HEIGHT / 2.0) <= EPSILON) ? "" : "not "
    );
  }
  
}
