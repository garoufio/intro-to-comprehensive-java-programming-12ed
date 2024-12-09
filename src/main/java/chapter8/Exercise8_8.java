package chapter8;

import java.util.Scanner;

/**
 * (All closest pairs of points) Revise Listing 8.3, FindNearestPoints.java, to display
 * all closest pairs of points with the same minimum distance.
 */
public class Exercise8_8 {
  
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      int numberOfPoints = readNumberOfPoints(input);
      double[][] points = readPoints(input, numberOfPoints);
      printNearestPoints(points);
    }
    catch (Exception e) {
      System.err.println("Invalid input");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readNumberOfPoints(Scanner scanner) {
    int numberOfPoints;
    do {
      System.out.print("Enter the number of points: ");
      numberOfPoints = scanner.nextInt();
      if (numberOfPoints <= 0) {
        System.out.println("Number of points must be greater than 0");
      }
    } while (numberOfPoints <= 0);
    scanner.nextLine();
    
    return numberOfPoints;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readPoints(Scanner scanner, int numberOfPoints) {
    double[][] points = new double[numberOfPoints][2];
    
    System.out.printf("Enter '%d' points: ", numberOfPoints);
    for (int i = 0; i < numberOfPoints; i++) {
      points[i][0] = scanner.nextDouble();
      points[i][1] = scanner.nextDouble();
    }
    scanner.nextLine();
    return points;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double calculateDistance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double getMinDistance(double[][] points) {
    if (points.length < 2) {
      return calculateDistance(0.0, 0.0, points[0][0], points[0][1]);
    }
    
    double distance;
    // calculate initial distance
    double minDistance = calculateDistance(points[0][0], points[0][1], points[1][0], points[1][1]);
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        distance = calculateDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
        if (distance < minDistance) {
          minDistance = distance;
        }
      }
    }
    return minDistance;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printNearestPoints(double points[][]) {
    double minDistance = getMinDistance(points);
    double distance;
    
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        distance = calculateDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
        
        if (Math.abs(distance - minDistance) < 0.00001) {
          System.out.printf(
              "The closest two points are (%.1f, %.1f) and (%.1f, %.1f)\n",
              points[i][0], points[i][1], // point1
              points[j][0], points[j][1] // point2
          );
        }
      }
    }
    System.out.printf("Their distance is %f\n", minDistance);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
