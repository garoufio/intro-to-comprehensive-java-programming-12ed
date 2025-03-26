package chapter8;

import java.util.Scanner;

/**
 * (Geometry: area of a triangle)  The program prompts the user to enter the x and y coordinates of a triangle and
 * stores them in a 3x2 two-dimensional array. Then it computes and prints the area of the triangle. If the area is 0,
 * the points are on the same line.
 */
public class Exercise8_32 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      double[][] points = readPoints(sc);
      double area = getTriangleArea(points);
      
      if (Math.abs(area) < 0.0001 || Double.isNaN(area)) {
        System.out.println("The three points are on the same line");
      }
      else {
        System.out.printf("The area of the triangle is '%.2f'\n", area);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double getTriangleArea(double[][] points) {
    double side1 = Math.pow(Math.pow(points[1][0] - points[0][0], 2) + Math.pow(points[1][1] - points[0][1], 2), 0.5);
    double side2 = Math.pow(Math.pow(points[2][0] - points[1][0], 2) + Math.pow(points[2][1] - points[1][1], 2), 0.5);
    double side3 = Math.pow(Math.pow(points[2][0] - points[0][0], 2) + Math.pow(points[2][1] - points[0][1], 2), 0.5);
    double semiPerimeter = (side1 + side2 + side3) / 2;
    return Math.pow(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3), 0.5);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readPoints(Scanner sc) {
    double[][] points = new double[3][2];
    
    System.out.print("Enter x1, y1, x2, y2, x3, y3: ");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 2; j++) {
        points[i][j] = sc.nextDouble();
      }
    }
    return points;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
