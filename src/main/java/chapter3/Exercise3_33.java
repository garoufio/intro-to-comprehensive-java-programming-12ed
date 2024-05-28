package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter the weight and the price of two packages of the same product, and then compares the cost
 * between these packages.
 */
public class Exercise3_33 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double weight1, price1, weight2, price2;
    
    System.out.print("Enter weight and price for package1: ");
    weight1 = input.nextDouble();
    price1 = input.nextDouble();
    System.out.print("Enter weight and price for package2: ");
    weight2 = input.nextDouble();
    price2 = input.nextDouble();
    input.close();
    
    double ratio1 = price1 / weight1;
    double ratio2 = price2 / weight2;
    if (ratio1 > ratio2) {
      System.out.println("Package 2 has better price");
    }
    else if (ratio1 < ratio2) {
      System.out.println("Package 1 has better price");
    }
    else {
      System.out.println("Two packages have same price");
    }
  }
  
}
