package chapter3;

import java.util.Scanner;

/**
 * Calculates the quadratic equation and displays the result.
 */
public class Exercise3_1 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double a, b, c, r1, r2, discriminant;
    
    System.out.print("Enter three numbers (a, b, c): ");
    a = input.nextDouble();
    b = input.nextDouble();
    c = input.nextDouble();
    input.close();
    
    discriminant = Math.pow(b, 2) - (4 * a * c);
    if (discriminant < 0) {
      System.out.println("The equation has no real roots");
    }
    else if (discriminant > 0) {
      r1 = (-b + Math.sqrt(discriminant)) / (2 * a);
      r2 = (-b - Math.sqrt(discriminant)) / (2 * a);
      System.out.printf("The equation has two roots '%f' and '%f'\n", r1, r2);
    }
    else {
      r1 = -b / (2 * a);
      System.out.printf("The equation has one root '%f'\n", r1);
    }
  }
  
}
