package chapter4;

import java.util.Scanner;

public class Exercise4_26 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String inputAmount;
    int amount, remainingAmount, dollars, quarters, dimes, nickels, pennies;
    
    System.out.print("Enter the number of dollars: ");
    inputAmount = input.nextLine();
    input.close();
    
    int decimalPosition = inputAmount.indexOf('.');
    if (decimalPosition == -1) {
      amount = 100 * Integer.parseInt(inputAmount);
    }
    else {
      String fractionPart = inputAmount.substring(decimalPosition + 1);
      fractionPart = switch (fractionPart.length()) {
        case 0 -> "00";
        case 1 -> fractionPart + "0";
        default -> fractionPart.substring(0, 2);
      };
      
      amount = Integer.parseInt(inputAmount.substring(0, decimalPosition) + fractionPart);
    }
    
    // number of dollars
    remainingAmount = amount;
    dollars = remainingAmount / 100;
    // number of quarters
    remainingAmount %= 100;
    quarters = remainingAmount / 25;
    // number of dimes
    remainingAmount %= 25;
    dimes = remainingAmount / 10;
    // number of nickels
    remainingAmount %= 10;
    nickels = remainingAmount / 5;
    // number of pennies
    pennies = remainingAmount % 5;
    
    System.out.printf(
        "$%s consists of %d dollars, %d quarters, %d dimes, %d nickels, %d pennies\n",
        inputAmount, dollars, quarters, dimes, nickels, pennies
    );
  }
  
}
