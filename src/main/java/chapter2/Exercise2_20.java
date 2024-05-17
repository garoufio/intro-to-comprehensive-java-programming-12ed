package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the interest of the next month given the annual interest rate and the balance.
 */
public class Exercise2_20 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double balance, annualInterestRate, interest;
    
    System.out.print("Enter balance and interest rate (e.g., 3 for 3%): ");
    balance = input.nextDouble();
    annualInterestRate = input.nextDouble();
    input.close();
    
    interest = balance * (annualInterestRate / 1200);
    System.out.printf("The interest is '%.2f'\n", interest);
  }
  
}
