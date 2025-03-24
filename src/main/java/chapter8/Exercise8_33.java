package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * (Geometry: polygon subareas) A convex four-vertex polygon is divided into four triangles. The program prompts the
 * user to enter the coordinates of four vertices and displays the areas of the four triangles in increasing order.
 */
public class Exercise8_33 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      double[][] points = readPolygonCoordinates(sc);
      double[] areas = getFourVertexAreas(points);
      
      System.out.println("The sorted areas of the four triangles are:");
      for (double area : areas) {
        System.out.printf("%.2f\n", area);
      }
    }
    catch (Exception e) {
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
  
  public static double[] getFourVertexAreas(double[][] points) {
    double[] areas = new double[4];
    double[][] triangle = new double[3][2];
    
    
    
    Arrays.sort(areas);
    return areas;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readPolygonCoordinates(Scanner sc) {
    double[][] points = new double[4][2];
    
    System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        points[i][j] = sc.nextDouble();
      }
    }
    return points;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
