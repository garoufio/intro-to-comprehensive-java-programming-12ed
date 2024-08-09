package chapter6;

import java.util.Scanner;

/**
 * Computes and displays the future investment value.
 */
public class Exercise6_7 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("The amount invested: ");
    double investmentAmount = input.nextDouble();
    System.out.printf("Annual interest rate in percentage: ");
    double annualInterestRate = input.nextDouble();
    input.close();
    
    double monthlyInterestRate = annualInterestRate / 12;
    displayTitle();
    displayBody(investmentAmount, monthlyInterestRate);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
    return investmentAmount * Math.pow(1 + (monthlyInterestRate / 100), years * 12);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayTitle() {
    System.out.printf("%-10s%-15s\n", "Years", "Future value");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayBody(double investmentAmount, double monthlyInterestRate) {
    
    for (int year = 1; year <= 30; year++) {
      System.out.printf("%-7d%15.2f\n", year, futureInvestmentValue(investmentAmount, monthlyInterestRate, year));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
