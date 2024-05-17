package chapter2;

import java.util.Scanner;

public class ComputeChange {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double inputAmount;
    int remainingAmount, dollars, quarters, dimes, nickels, pennies;
    
    System.out.print("Enter the number of dollars: ");
    inputAmount = input.nextDouble();
    input.close();
    
    // number of dollars
    remainingAmount = (int)(inputAmount * 100);
    dollars = remainingAmount / 100;
    // number of quarters
    remainingAmount %= 100;
    quarters = remainingAmount / 25;
    // number of dimes
    remainingAmount %= 25;
    dimes = remainingAmount / 10;
    // number of nickels
    remainingAmount %= 10;
    nickels = remainingAmount / 5;
    // number of pennies
    pennies = remainingAmount % 5;
    
    System.out.printf(
        "$%.2f consists of %d dollars, %d quarters, %d dimes, %d nickels, %d pennies\n",
        inputAmount, dollars, quarters, dimes, nickels, pennies
    );
  }
  
}
