package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the distance of the given two points.
 */
public class Exercise2_15 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double pointX1, pointX2, pointY1, pointY2, distance;
    
    System.out.print("Enter x1 and y1: ");
    pointX1 = input.nextDouble();
    pointY1 = input.nextDouble();
    System.out.print("Enter x2 and y2: ");
    pointX2 = input.nextDouble();
    pointY2 = input.nextDouble();
    input.close();
    
    distance = Math.pow(Math.pow(pointX2 - pointX1, 2) + Math.pow(pointY2 - pointY1, 2), 0.5);
    System.out.printf("The distance between the two points is '%.2f'\n", distance);
  }
  
}
