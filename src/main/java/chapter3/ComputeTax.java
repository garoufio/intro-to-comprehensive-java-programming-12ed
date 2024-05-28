package chapter3;

import java.util.Scanner;

public class ComputeTax {
  
  public static final double EPSILON = 10E-14;
  
  public static void main(String[] args) {
    Scanner input =  new Scanner(System.in);
    int filingStatus;
    double income, tax;
    
    System.out.printf(
        "0 - single filler\n1 - married jointly or qualifying widow(er)\n" +
        "2 - married separately\n3 - head of household\nEnter the filing status: "
    );
    filingStatus = input.nextInt();
    
    System.out.print("Enter the taxable income: ");
    income = input.nextDouble();
    input.close();
    
    // Compute tax
    tax = 0;
    if (filingStatus == 0) {
      if (income - 8350 <= EPSILON) {
        tax = income * 0.10;
      }
      else if (income - 33950 <= EPSILON) {
        tax = (8350 * 0.10) + ((income - 8350) * 0.15);
      }
      else if (income - 82250 <= EPSILON) {
        tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((income - 33950) * 0.25);
      }
      else if (income - 171550 <= EPSILON) {
        tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((82250 - 33950) * 0.25) + ((income - 82250) * 0.28);
      }
      else if (income - 372950 <= EPSILON) {
        tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((82250 - 33950) * 0.25) + ((171550 - 82250) * 0.28) +
            ((income - 171550) * 0.33);
      }
      else {
        tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((82250 - 33950) * 0.25) + ((171550 - 82250) * 0.28) +
            ((372950 - 171550) * 0.33) + ((income - 372950) * 0.35);
      }
    }
    else if (filingStatus == 1) {
      if (income - 16700 <= EPSILON) {
        tax = income * 0.10;
      }
      else if (income - 67900 <= EPSILON) {
        tax = (16700 * 0.10) + ((income - 16700) * 0.15);
      }
      else if (income - 137050 <= EPSILON) {
        tax = (16700 * 0.10) + ((67900 - 16700) * 0.15) + ((income - 67900) * 0.25);
      }
      else if (income - 208850 <= EPSILON) {
        tax = (16700 * 0.10) + ((67900 - 16700) * 0.15) + ((137050 - 67900) * 0.25) + ((income - 137050) * 0.28);
      }
      else if (income - 372950 <= EPSILON) {
        tax = (16700 * 0.10) + ((67900 - 16700) * 0.15) + ((137050 - 67900) * 0.25) + ((208850 - 137050) * 0.28) +
            ((income - 208850) * 0.33);
      }
      else {
        tax = (16700 * 0.10) + ((67900 - 16700) * 0.15) + ((137050 - 67900) * 0.25) + ((208850 - 137050) * 0.28) +
            ((372950 - 208850) * 0.33) + ((income - 372950) * 0.35);
      }
    }
    else if (filingStatus == 2) {
      if (income - 8350 <= EPSILON) {
        tax = income * 0.10;
      }
      else if (income - 33950 <= EPSILON) {
        tax = (8350 * 0.10) + ((income - 8350) * 0.15);
      }
      else if (income - 68525 <= EPSILON) {
        tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((income - 33950) * 0.25);
      }
      else if (income - 104425 <= EPSILON) {
        tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((68525 - 33950) * 0.25) + ((income - 68525) * 0.28);
      }
      else if (income - 186475 <= EPSILON) {
        tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((68525 - 33950) * 0.25) + ((104425 - 68525) * 0.28) +
            ((income - 104425) * 0.33);
      }
      else {
        tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((68525 - 33950) * 0.25) + ((104425 - 68525) * 0.28) +
            ((186475 - 104425) * 0.33) + ((income - 186475) * 0.35);
      }
    }
    else if (filingStatus == 3) {
      if (income - 11950 <= EPSILON) {
        tax = income * 0.10;
      }
      else if (income - 45500 <= EPSILON) {
        tax = (11950 * 0.10) + ((income - 11950) * 0.15);
      }
      else if (income - 117450 <= EPSILON) {
        tax = (11950 * 0.10) + ((45500 - 11950) * 0.15) + ((income - 45500) * 0.25);
      }
      else if (income - 190200 <= EPSILON) {
        tax = (11950 * 0.10) + ((45500 - 11950) * 0.15) + ((117450 - 45500) * 0.25) + ((income - 117450) * 0.28);
      }
      else if (income - 372950 <= EPSILON) {
        tax = (11950 * 0.10) + ((45500 - 11950) * 0.15) + ((117450 - 45500) * 0.25) + ((190200 - 117450) * 0.28) +
            ((income - 190200) * 0.33);
      }
      else {
        tax = (11950 * 0.10) + ((45500 - 11950) * 0.15) + ((117450 - 33950) * 0.25) + ((190200 - 117450) * 0.28) +
            ((372950 - 190200) * 0.33) + ((income - 372950) * 0.35);
      }
    }
    else {
      System.out.println("Error: invalid status");
      System.exit(1);
    }
    
    System.out.printf("Tax is '$%.2f'\n", tax);
  }
  
}
