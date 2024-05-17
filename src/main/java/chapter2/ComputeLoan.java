package chapter2;

import java.util.Scanner;

/**
 * Computes the monthly payment and the total payment of a loan for a given loan amount, annual interest rate and
 * number of years.
 */
public class ComputeLoan {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numberOfYears;
    double annualInterestRate, monthlyInterestRate, monthlyPayment, totalPayment, loanAmount;
    
    // loan amount
    System.out.print("Enter loan amount: ");
    loanAmount = input.nextDouble();
    
    // annual interest rate and monthly interest rate
    System.out.print("Enter interest rate: ");
    annualInterestRate = input.nextDouble();
    monthlyInterestRate = annualInterestRate / 1200;
    
    // number of payments in years
    System.out.print("Enter number of years: ");
    numberOfYears = input.nextInt();
    
    input.close();
    
    monthlyPayment = (loanAmount * monthlyInterestRate) /
        (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    totalPayment = monthlyPayment * numberOfYears * 12;
    
    System.out.printf("Monthly payment is $%.2f\n", monthlyPayment);
    // use casting in order to round the payment up to 2 decimal places
    //System.out.println("Monthly payment is $" + (int)(monthlyPayment * 100) / 100.0);
    System.out.printf("Total payment is $%.2f\n", totalPayment);
    // use casting in order to round the payment up to 2 decimal places
    //System.out.println("Total payment is $" + (int)(totalPayment * 100) / 100.0);
  }
  
}
