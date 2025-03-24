package chapter8;

import java.util.Scanner;

/**
 * (Algebra: solve linear equations) The program solves the following 2 * 2 system of linear equations:
 * a00x + a01y = b0         b0a11 - b1a01           b1a00 - b0a10
 *                   , x = ----------------- , y = -----------------
 * a10x + a11y = b1         a00a11 - a01a10         a00a11 - a01a10
 *  The program prompts the user to enter a00, a01, a10, a11, b0, and b1 and displays the result. If a00a11 - a01a10
 *  is 0, report that “The equation has no solution.”
 */
public class Exercise8_30 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      double[][] a = readA(sc);
      double[] b = readB(sc);
      double[] result = linearEquation(a, b);
      
      if (result == null) {
        System.out.println("The equation has no solution");
      }
      else {
        System.out.printf("The equation has '%d' solutions: '%.2f' and '%.2f'\n", result.length, result[0], result[1]);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[] linearEquation(double[][] a, double[] b) {
    if (a == null || b == null) return null;
    
    if (Math.abs((a[0][0] * a[1][1]) - (a[0][1] * a[1][0])) < 0.0001) return null;
    
    double[] result = new double[2];
    result[0] = ((b[0] * a[1][1]) - (b[1] * a[0][1])) / ((a[0][0] * a[1][1]) - (a[0][1] * a[1][0]));
    result[1] = ((b[1] * a[0][0]) - (b[0] * a[1][0])) / ((a[0][0] * a[1][1]) - (a[0][1] * a[1][0]));
    
    return result;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readA(Scanner sc) {
    double[][] array = new double[2][2];
    System.out.println("Enter 2 x 2 matrix A: ");
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        array[i][j] = sc.nextDouble();
      }
    }
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[] readB(Scanner sc) {
    double[] array = new double[2];
    System.out.println("Enter 1 x 2 matrix B: ");
    for (int i = 0; i < 2; i++) {
      array[i] = sc.nextDouble();
    }
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
