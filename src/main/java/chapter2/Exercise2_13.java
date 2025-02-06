package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the account value after a period of 6 months, for 5% annual interest rate and a
 * given saving amount.
 */
public class Exercise2_13 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double savingAmount, totalAmount, monthlyInterestRate;
    
    System.out.print("Enter the monthly saving amount: ");
    savingAmount = input.nextDouble();
    input.close();
    
    monthlyInterestRate = (5 / 100.0) / 12;
    totalAmount = savingAmount;
    totalAmount = totalAmount * (1 + monthlyInterestRate); // after 1st month
    totalAmount = (savingAmount + totalAmount) * (1 + monthlyInterestRate); // after 2nd month
    totalAmount = (savingAmount + totalAmount) * (1 + monthlyInterestRate); // after 3rd month
    totalAmount = (savingAmount + totalAmount) * (1 + monthlyInterestRate); // after 4th month
    totalAmount = (savingAmount + totalAmount) * (1 + monthlyInterestRate); // after 5th month
    totalAmount = (savingAmount + totalAmount) * (1 + monthlyInterestRate); // after 6th month
    System.out.printf("After the sixth month, the account value is '$%.2f'\n", totalAmount);
  }
  
}
