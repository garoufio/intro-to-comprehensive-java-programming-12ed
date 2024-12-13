package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (Financial application: compute tax) Rewrite Listing 3.5, ComputeTax.java, using arrays. For each filing status,
 * there are six tax rates. Each rate is applied to a certain amount of taxable income. For example, from the taxable
 * income of $400,000 for a single filer:
 *  - $8,350 is taxed at 10%
 *  - (33,950 - 8,350) at 15%
 *  - (82,250 - 33,950) at 25%
 *  - (171,550 - 82,250) at 28%
 *  - (372,950 - 171,550) at 33%
 *  - (400,000 - 372,950) at 35%.
 *  The six rates are the same for all filing statuses, which can be represented in the following array:
 *    double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
 *  The brackets for each rate for all the filing statuses can be represented in a two-dimensional array as follows:
 *  int[][] brackets = {
 *    {8350, 33950, 82250, 171550, 372950},   // Single filer
 *    {16700, 67900, 137050, 20885, 372950},  // Married jointly − or qualifying widow(er)
 *    {8350, 33950, 68525, 104425, 186475},   // Married separately
 *    {11950, 45500, 117450, 190200, 372950}  // Head of household
 *  }
 *  The program prompts the user to enter his/her taxable income and filing status. Then computes and displays the tax.
 */
public class Exercise8_12 {
  
  public static final double EPSILON = 10E-5;
  public static final double[] RATES = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 };
  public static final int[][] BRACKETS = {
      { 8350, 33950, 82250, 171550, 372950 },   // Single filer
      { 16700, 67900, 137050, 20885, 372950 },  // Married jointly − or qualifying widow(er)
      { 8350, 33950, 68525, 104425, 186475 },   // Married separately
      { 11950, 45500, 117450, 190200, 372950 }  // Head of household
  };
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      int filingStatus = readFilingStatus(input);
      double income = readIncome(input);
      double tax = computeTax(income, filingStatus);
      System.out.printf("Tax is '$%.2f'\n", tax);
    }
    catch (InputMismatchException e) {
      System.err.println("Invalid input.");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean validateFilingStatus(int status) {
    if (status < 0 || status > 3) {
      System.out.println("Invalid filing status. Please try again.");
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean validateIncome(double income) {
    if (income <= 0) {
      System.out.println("Income cannot be less than or equal to $0. Please try again.");
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readFilingStatus(Scanner scanner) {
    int status;
    do {
      System.out.printf(
          "0 - Single filer\n" +
          "1 - Married jointly - or qualifying widow(e)\n" +
          "2 - Married separately\n" +
          "3 - Head of household\n" +
              "Enter filing status: "
      );
      status = scanner.nextInt();
    } while (!validateFilingStatus(status));
    
    return status;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double readIncome(Scanner scanner) {
    double income;
    do {
      System.out.print("Enter taxable income: ");
      income = scanner.nextDouble();
    } while (!validateIncome(income));
    
    return income;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeTax(double income, int filingStatus) {
    double tax;
    
    if (income - BRACKETS[filingStatus][0] <= EPSILON) {
      tax = income * RATES[0];
    }
    else if (income - BRACKETS[filingStatus][1] <= EPSILON) {
      tax = (BRACKETS[filingStatus][0] * RATES[0]) +
          ((income - BRACKETS[filingStatus][0]) * RATES[1]);
    }
    else if (income - BRACKETS[filingStatus][2] <= EPSILON) {
      tax = (BRACKETS[filingStatus][0] * RATES[0]) +
          ((BRACKETS[filingStatus][1] - BRACKETS[filingStatus][0]) * RATES[1]) +
          ((income - BRACKETS[filingStatus][1]) * RATES[2]);
    }
    else if (income - BRACKETS[filingStatus][3] <= EPSILON) {
      tax = (BRACKETS[filingStatus][0] * RATES[0])
          + ((BRACKETS[filingStatus][1] - BRACKETS[filingStatus][0]) * RATES[1]) +
          ((BRACKETS[filingStatus][2] - BRACKETS[filingStatus][1]) * RATES[2]) +
          ((income - BRACKETS[filingStatus][2]) * RATES[3]);
    }
    else if (income - BRACKETS[filingStatus][4] <= EPSILON) {
      tax = (BRACKETS[filingStatus][0] * RATES[0]) +
          ((BRACKETS[filingStatus][1] - BRACKETS[filingStatus][0]) * RATES[1]) +
          ((BRACKETS[filingStatus][2] - BRACKETS[filingStatus][1]) * RATES[2]) +
          ((BRACKETS[filingStatus][3] - BRACKETS[filingStatus][2]) * RATES[3]) +
          ((income - BRACKETS[filingStatus][3]) * RATES[4]);
    }
    else {
      tax = (BRACKETS[filingStatus][0] * RATES[0]) +
          ((BRACKETS[filingStatus][1] - BRACKETS[filingStatus][0]) * RATES[1]) +
          ((BRACKETS[filingStatus][2] - BRACKETS[filingStatus][1]) * RATES[2]) +
          ((BRACKETS[filingStatus][3] - BRACKETS[filingStatus][2]) * RATES[3]) +
          ((BRACKETS[filingStatus][4] - BRACKETS[filingStatus][3]) * RATES[4]) +
          ((income - BRACKETS[filingStatus][4]) * RATES[5]);
    }
    return tax;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
