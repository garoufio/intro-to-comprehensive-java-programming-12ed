package chapter3;

import java.util.Scanner;

/**
 * Calculates the cost of shipping for a given weight in pounds.
 */
public class Exercise3_18 {
  
  public static final double EPSILON = 10E-14;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double weight;
    
    System.out.print("Enter weight in pounds: ");
    weight = input.nextDouble();
    input.close();
    
    double shippingCost = 0.0;
    if (weight <= EPSILON) {
      System.out.println("Invalid input");
      System.exit(1);
    }
    else if (weight <= 1) {
      shippingCost = 3.5;
    }
    else if (weight <= 3) {
      shippingCost = 5.5;
    }
    else if (weight <= 10) {
      shippingCost = 8.5;
    }
    else if (weight <= 20) {
      shippingCost = 10.5;
    }
    else {
      System.out.println("The package cannot be shipped");
      System.exit(1);
    }
    System.out.printf("The shipping cost is '$%.2f'\n", shippingCost);
  }

}
