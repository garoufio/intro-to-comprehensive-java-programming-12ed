package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * (Geometry: polygon subareas) A convex four-vertex polygon is divided into four triangles. The program prompts the
 * user to enter the coordinates of four vertices and displays the areas of the four triangles in increasing order.
 * The area of the triangle is calculated using the Heron's formula.
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
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double getTriangleArea(double[][] points) {
    // calculate the length of each side
    double side1 = Math.sqrt(Math.pow(points[1][0] - points[0][0], 2) + Math.pow(points[1][1] - points[0][1], 2));
    double side2 = Math.sqrt(Math.pow(points[2][0] - points[1][0], 2) + Math.pow(points[2][1] - points[1][1], 2));
    double side3 = Math.sqrt(Math.pow(points[2][0] - points[0][0], 2) + Math.pow(points[2][1] - points[0][1], 2));
    double semiPerimeter = (side1 + side2 + side3) / 2.0;
    return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[] getFourVertexAreas(double[][] points) {
    double[] areas = new double[4];
    double[][] triangle = new double[3][2];
    
    int index = 0;
    for (int i = 0; i < points[0].length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        for (int k = j + 1; k < points.length; k++) {
          copy(points, triangle, i, j, k);
          areas[index] = getTriangleArea(triangle);
          index++;
        }
      }
    }
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
  
  public static void copy(double[][] source, double[][] target, int ...indices) {
    for (int i = 0; i < target.length; i++) {
      target[i][0] = source[indices[i]][0];
      target[i][1] = source[indices[i]][1];
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
