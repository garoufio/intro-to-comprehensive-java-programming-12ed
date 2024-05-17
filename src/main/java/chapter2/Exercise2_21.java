package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the future investment value given the investment amount, annual interest rate and number of
 * years.
 */
public class Exercise2_21 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double investmentAmount, annualInterestRate, futureValue;
    int years;
    
    System.out.print("Enter investment amount: ");
    investmentAmount = input.nextDouble();
    System.out.printf("Enter annual interest rate in percentage: ");
    annualInterestRate = input.nextDouble();
    System.out.print("Enter number of years: ");
    years = input.nextInt();
    input.close();
    
    futureValue = investmentAmount * Math.pow(1 + (annualInterestRate / 1200), years * 12);
    System.out.printf("Future value is '$%.2f'\n", futureValue);
  }
  
}
