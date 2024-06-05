package chapter4;

import java.util.Scanner;

/**
 * Financial application: payroll.
 */
public class Exercise4_23 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter employee's name: ");
    String name = input.nextLine();
    System.out.print("Enter number of hours worked in a week: ");
    double hours = input.nextDouble();
    System.out.print("Enter hourly pay rate: ");
    double payRate = input.nextDouble();
    System.out.print("Enter federal tax withholding rate: ");
    double federalTax = input.nextDouble();
    System.out.print("Enter state tax withholding rate: ");
    double stateTax = input.nextDouble();
    input.close();
    
    double grossPay = hours * payRate;
    double federalWithholding = federalTax * grossPay;
    double stateWithholding = stateTax * grossPay;
    System.out.printf("\nEmployee's name: %s\n", name);
    System.out.printf("Hours worked: %.2f\n", hours);
    System.out.printf("Pay rate: $%.2f\n", payRate);
    System.out.printf("Gross pay: $%.2f\n", grossPay);
    System.out.println("Deductions:");
    System.out.printf("\tFederal withholding (%.2f%%): $%.2f\n", federalTax * 100.0, federalWithholding);
    System.out.printf("\tState withholding (%.2f%%): $%.2f\n", stateTax * 100.00, stateWithholding);
    System.out.printf("\tTotal Deduction: $%.2f\n", federalWithholding + stateWithholding);
    System.out.printf("Net pay: $%.2f\n", grossPay - federalWithholding - stateWithholding);
  }
  
}
