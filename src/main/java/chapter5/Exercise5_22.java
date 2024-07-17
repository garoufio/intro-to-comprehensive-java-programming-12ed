package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter the loan amount, number of years, and interest rate and then displays the amortization
 * schedule for the loan. The monthly payment for a given loan pays the principal and the interest. The monthly
 * interest is computed by multiplying the monthly interest rate and the balance (the remaining principal). The
 * principal paid for the month is therefore the monthly payment minus the monthly interest.
 */
public class Exercise5_22 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double loanAmount, annualInterestRate;
    int numberOfYears;
    
    System.out.print("Enter loan amount: ");
    loanAmount = input.nextDouble();
    System.out.print("Enter interest rate: ");
    annualInterestRate = input.nextDouble();
    System.out.print("Enter number of years: ");
    numberOfYears = input.nextInt();
    input.close();
    
    if (loanAmount <= 0 || annualInterestRate <= 0 || numberOfYears <= 0) {
      System.out.println("Invalid input");
      System.exit(1);
    }
    
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = (loanAmount * monthlyInterestRate) /
        (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    double balance = loanAmount;
    double interest, principal;
    System.out.printf("%-20s%-20s%-20s%-20s\n", "Payment#", "Interest", "Principal", "Balance");
    for (int i = 1; i <= numberOfYears * 12; i++) {
      interest = monthlyInterestRate * balance;
      principal = monthlyPayment - interest;
      balance = balance - principal;

      System.out.printf(
          "%-20d%-20s%-20s%-20s\n",
          i,
          String.format("%%%-16.2f", interest),
          String.format("$%-16.2f", principal),
          String.format("$%-16.2f", balance)
      );
    }
    
  }
  
}
