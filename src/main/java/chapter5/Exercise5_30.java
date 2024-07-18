package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter an amount (e.g., $100), the annual interest rate (e.g., 5%), and the number of months
 * (e.g., 6). Then computes and displays the amount in the savings account after the given month.
 */
public class Exercise5_30 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double amount, annualInterestRate = 0;
    int months = 0;
    boolean isValidInput = true;
    
    System.out.print("Enter the amount: ");
    amount = input.nextDouble();
    if (amount <= 0) {
      System.out.println("The amount must be greater than 0");
      isValidInput = false;
    }
    if (isValidInput) {
      System.out.print("Enter annual interest rate: ");
      annualInterestRate = input.nextDouble();
      if (annualInterestRate <= 0) {
        System.out.println("The annual interest rate must be greater than 0");
        isValidInput = false;
      }
    }
    if (isValidInput) {
      System.out.print("Enter months: ");
      months = input.nextInt();
      if (months <= 0) {
        System.out.println("The months must be greater than 0");
        isValidInput = false;
      }
    }
    input.close();
    if (!isValidInput) {
      System.exit(1);
    }
    
    double monthlyInterestRate = annualInterestRate / 1200;
    double totalAmount = 0;
    for (int month = 0; month < months; month++) {
      totalAmount = (amount + totalAmount) * (1 + monthlyInterestRate);
      System.out.printf("Amount: %.3f\n", totalAmount);
    }
  }
  
}