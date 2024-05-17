package chapter2;

import java.util.Scanner;

/**
 * Calculates the gratuity and the total for a given subtotal and gratuity rate and displays the results.
 */
public class Exercise2_5 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double gratuity, gratuityRate, total, subtotal;
    
    System.out.print("Enter the subtotal and the gratuity rate: ");
    subtotal = input.nextDouble();
    gratuityRate = input.nextDouble();
    input.close();
    
    gratuity = gratuityRate / 10;
    total = subtotal + gratuity;
    System.out.printf("The gratuity is $%.2f and the total is $%.2f\n", gratuity, total);
  }
  
}
