package chapter5;

import java.util.Scanner;

/**
 *  Prompts the user to enter the loan amount and loan period in number of years, and displays the monthly and total
 *  payments for each interest rate starting from 5% to 8%, with an ammual increment of 1/8.
 */

public class Exercise5_21 {
  
  public static final double STARTING_INTEREST_RATE = 5;
  public static final double ENDING_INTEREST_RATE = 8;
  public static final double ANNUAL_INTEREST_RATE_RAISE = (1 / (double)8) / 100;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double loanAmount;
    int loanPeriodInYears;
    
    System.out.print("Enter loan amount: ");
    loanAmount = input.nextDouble();
    System.out.print("Enter interest rate: ");
    loanPeriodInYears = input.nextInt();
    input.close();
    
    if (loanAmount <= 0 || loanPeriodInYears <= 0) {
      System.out.println("Invalid input");
      System.exit(1);
    }
    
    
    double interestRate = STARTING_INTEREST_RATE / 100;
    double monthlyInterestRate, totalPayment, monthlyPayment;
    System.out.printf("%-20s%-20s%-20s\n", "Interest Rate", "Monthly payment", "Total payment");
    do {
      monthlyInterestRate = interestRate / 12;
      monthlyPayment = (loanAmount * monthlyInterestRate) /
          (1 - (1 / Math.pow(1 + monthlyInterestRate, loanPeriodInYears * 12)));
      totalPayment = monthlyPayment * loanPeriodInYears * 12;
      
      System.out.printf(
          "%-20s%-20s%-20s\n",
          String.format("%%%-15.3f", interestRate * 100),
          String.format("$%-16.2f", monthlyPayment),
          String.format("$%-16.2f", totalPayment)
          );
      
      interestRate += ANNUAL_INTEREST_RATE_RAISE;
    } while (interestRate <= ENDING_INTEREST_RATE / 100 + 0.000001);
  }
  
}
