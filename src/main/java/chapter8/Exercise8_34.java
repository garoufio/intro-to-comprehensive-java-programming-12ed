package chapter8;

import java.util.Scanner;

/**
 * (Geometry: rightmost lowest point) In computational geometry, often you need to find the rightmost lowest point in a
 * set of points. The program prompts the user to enter the coordinates of n points and displays the rightmost lowest
 * point.
 */
public class Exercise8_34 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int numberOfPoints = getNumberOfPoints(sc);
      double[][] points = readPoints(sc, numberOfPoints);
      double[] lowestPoint = getRightmostLowestPoint(points);

      System.out.printf("The rightmost lowest point is (%.2f, %.2f)\n", lowestPoint[0], lowestPoint[1]);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[] getRightmostLowestPoint(double[][] points) {
    if (points == null || points.length == 0) return null;
    
    double[] lowestPoint = new double[2];
    lowestPoint[0] = points[0][0];
    lowestPoint[1] = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if ((points[i][0] > lowestPoint[0]) && (points[i][1] <= lowestPoint[1])) {
        lowestPoint[0] = points[i][0];
        lowestPoint[1] = points[i][1];
      }
    }
    return lowestPoint;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getNumberOfPoints(Scanner sc) {
    int numberOfPoints;
    
    do {
      System.out.print("Enter the number of points: ");
      numberOfPoints = sc.nextInt();
      if (numberOfPoints <= 0) System.out.println("Number of points must be greater than 0");
    } while (numberOfPoints <= 0);
    
    return numberOfPoints;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readPoints(Scanner sc, int numberOfPoints) {
    double[][] points = new double[numberOfPoints][2];
    
    System.out.printf("Enter '%d' points: ", numberOfPoints);
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        points[i][j] = sc.nextDouble();
      }
    }
    return points;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
