package chapter8;

import java.util.Scanner;

/**
 * Prompts the user to enter five points and displays whether they are on the same line or not.
 */
public class Exercise8_15 {
  
  public static final int NUMBER_OF_POINTS = 5;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      double[][] points = readPoints(input);
      
      if (arePointsOnTheSameLine(points)) {
        System.out.println("The five points are on the same line");
      }
      else {
        System.out.println("The five points are not on the same line");
      }
    }
    catch (Exception e) {
      System.err.println("Invalid input. Program will exit." + e);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readPoints(Scanner scanner) {
    double[][] points = new double[NUMBER_OF_POINTS][2];
    
    System.out.print("Enter five points: ");
    for (int i = 0; i < NUMBER_OF_POINTS; i++) {
      for (int j = 0; j < 2; j++) {
        points[i][j] = scanner.nextDouble();
      }
    }
    return points;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  //double x0, double y0, double x1, double y1, double x2, double y2
  public static double equation(double[] p0, double[] p1, double[] p2) {
    return (p1[0] - p0[0]) * (p2[1] - p0[1]) - (p2[0] - p0[0]) * (p1[1] - p0[1]);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean onTheSameLine(double[] p0, double[] p1, double[] p2) {
    return Math.abs(equation(p0, p1, p2)) == 0D;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean arePointsOnTheSameLine(double[][] points) {
    boolean areOnSameLine = true;
    
    areOnSameLine = onTheSameLine(points[0], points[1], points[2]);
    if (!areOnSameLine) return false;
    
    return onTheSameLine(points[2], points[3], points[4]);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
