package chapter3;

import java.util.Scanner;

/**
 * Solves a linear equation of given values a, b, c, d, e and f using the Crammer's rule and displays the result.
 */
public class Exercise3_3 {
  
  public static final double EPSILON = 1E-14;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double a, b, c, d, e, f, divisor;
    
    System.out.print("Enter six numbers: ");
    a = input.nextDouble();
    b = input.nextDouble();
    c = input.nextDouble();
    d = input.nextDouble();
    e = input.nextDouble();
    f = input.nextDouble();
    input.close();
    
    divisor = (a * d) - (b * c);
    if (Math.abs(divisor) < EPSILON) {
      System.out.println("The equation has no solution");
    }
    else {
      double x, y;
      x = ((e * d) - (b * f)) / divisor;
      y = ((a * f) - (e * c)) / divisor;
      System.out.printf("x is '%.2f' and y is '%.2f'\n", x, y);
    }
  }
  
}
