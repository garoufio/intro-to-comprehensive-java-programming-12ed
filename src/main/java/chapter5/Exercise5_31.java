package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter an amount (e.g., 10000), the annual percentage yield (e.g., 5.75), and the number of
 * months (e.g., 18). Then it computes and displays the CD value per month.
 */
public class Exercise5_31 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double amount;
    double annualPercentage = 0;
    int months = 0;
    boolean isValidInput = true;
    
    System.out.print("Enter the initial deposit amount: ");
    amount = input.nextDouble();
    if (amount <= 0) {
      System.out.println("The amount must be greater than 0.");
      isValidInput = false;
    }
    if (isValidInput) {
      System.out.print("Enter the annual percentage: ");
      annualPercentage = input.nextDouble();
      if (annualPercentage <= 0) {
        System.out.println("The annual percentage must be greater than 0.");
        isValidInput = false;
      }
    }
    if (isValidInput) {
      System.out.print("Enter the months: ");
      months = input.nextInt();
      if (months <= 0) {
        System.out.println("The months must be greater than 0.");
        isValidInput = false;
      }
    }
    input.close();
    if (!isValidInput) System.exit(1);
    
    double monthlyInterestRate = annualPercentage / 1200;
    double monthlyAmount = amount;
    System.out.printf("%-10s%-20s\n", "Month", "CD Value");
    for (int month = 1; month <= months; month++) {
      monthlyAmount += monthlyInterestRate * monthlyAmount;
      System.out.printf("%-10d%-17.2f\n", month, monthlyAmount);
    }
  }
  
}
