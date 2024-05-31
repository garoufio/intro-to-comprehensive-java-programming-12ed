package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter the latitude and the longitude of two points, and then it computes the great circle
 * distance between these points on the surface of a sphere.
 */
public class Exercise4_2 {
  
  public static final double AVERAGE_RADIUS_OF_EARTH = 6378.01;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter point1 (latitude and longitude): ");
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    System.out.print("Enter point2 (latitude and longitude): ");
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
    input.close();
    
    double distance = AVERAGE_RADIUS_OF_EARTH * Math.acos(
      Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) +
          Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) *
              Math.cos(Math.toRadians(y1 - y2))
    );
    System.out.printf("The distance between the two points '%f' km\n", distance);
  }
  
}
