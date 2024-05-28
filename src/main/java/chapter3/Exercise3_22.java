package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter a point in x and y-axis, and then it checks whether that point is within a circle centered
 * in (0, 0) with radius 10.
 */
public class Exercise3_22 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double pointX, pointY;
    
    System.out.print("Enter a point with two coordinates: ");
    pointX = input.nextDouble();
    pointY = input.nextDouble();
    input.close();
    
    double distance = Math.sqrt(Math.pow(pointX, 2) + Math.pow(pointY, 2));
    System.out.printf(
        "Point '(%f, %f)' is %sin the circle\n", pointX, pointY, (distance - 10 <= 1E-14) ? "" : "not "
    );
  }
  
}
