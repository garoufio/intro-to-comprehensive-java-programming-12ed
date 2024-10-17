package chapter7;

import java.util.Scanner;

/**
 * Prompts the user to enter values for a, b, and c and displays the number of real roots and all real roots by solving
 * the quadratic equation.
 */
public class Exercise7_25 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double[] coefficients = readCoefficients(input);
    double[] roots = new double[2];
    input.close();
    
    int numberOfRealRoots = solveQuadratic(coefficients, roots);
    printRealRoots(numberOfRealRoots, roots);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int solveQuadratic(double[] eqn, double[] roots) {
    double discriminant = getDiscriminant(eqn);
    
    if (discriminant < 0) {
      return 0;
    }
    else if (discriminant > 0) {
      roots[0] = (-eqn[1] + Math.sqrt(discriminant)) / (2 * eqn[0]);
      roots[1] = (-eqn[1] - Math.sqrt(discriminant)) / (2 * eqn[0]);
      return 2;
    }
    else {
      roots[0] = -eqn[1] / (2 * eqn[0]);
      roots[1] = roots[0];
      return 1;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double getDiscriminant(double[] eqn) {
    return Math.pow(eqn[1], 2) - (4 * eqn[0] * eqn[2]);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[] readCoefficients(Scanner scanner) {
    double[] coefficients = new double[3];
    
    System.out.print("Enter coefficients a, b and c: ");
    for (int i = 0; i < 3; i++) {
      coefficients[i] = scanner.nextDouble();
    }
    return coefficients;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printRealRoots(int numberOfRealRoots, double[] roots) {
    switch (numberOfRealRoots) {
      case 0 -> System.out.println("The equation has no real roots");
      case 1 -> System.out.printf("The equation has one root '%f'\n", roots[0]);
      case 2 -> System.out.printf("The equation has two roots '%f' and '%f'\n", roots[0], roots[1]);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
