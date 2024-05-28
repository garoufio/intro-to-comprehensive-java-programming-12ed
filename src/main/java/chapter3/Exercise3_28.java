package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter the center x- and y- coordinates, width and height of two rectangles, and then it
 * determines whether the second rectangle is inside the first or overlaps with the first.
 */
public class Exercise3_28 {
  
  public static final double EPSILON = 1E-14;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double centerX1, centerY1, width1, height1, centerX2, centerY2, width2, height2;
    
    System.out.print("Enter rectangle's r1 center x-, y- coordinates, width and height: ");
    centerX1 = input.nextDouble();
    centerY1 = input.nextDouble();
    width1 = input.nextDouble();
    height1 = input.nextDouble();
    System.out.print("Enter rectangle's r2 center x-, y- coordinates, width and height: ");
    centerX2 = input.nextDouble();
    centerY2 = input.nextDouble();
    width2 = input.nextDouble();
    height2 = input.nextDouble();
    input.close();
    
    // distance between centerX1 and centerX2
    double distnaceX = Math.sqrt(Math.pow(centerX2 - centerX1, 2));
    // distance between centerY1 and centerY2
    double distnaceY = Math.sqrt(Math.pow(centerY2 - centerY1, 2));
    
    boolean isInside = false;
    boolean doOverlap = false;
    if (distnaceX <= width1 / 2.0) {
      if (distnaceY <= height1 / 2.0) {
        if (width2 <= width1 && height2 <= height1) {
          isInside = true;
        }
        else {
          doOverlap = true;
        }
      }
      else if (distnaceY <= height1) {
        doOverlap = true;
      }
    }
    else if (distnaceX <= width1) {
      if (distnaceY <= height1) {
        doOverlap = true;
      }
    }
    if (isInside) {
      System.out.println("r2 is inside r1");
    }
    else if (doOverlap) {
      System.out.println("r2 overlaps r1");
    }
    else {
      System.out.println("r2 does not overlap r1");
    }
  }
  
}
