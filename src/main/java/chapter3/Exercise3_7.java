package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter an amount in dollars and computes and displays the monetary units.
 */
public class Exercise3_7 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double inputAmount;
    int remainingAmount, dollars, quarters, dimes, nickels, pennies;
    
    System.out.print("Enter the number of dollars: ");
    inputAmount = input.nextDouble();
    input.close();
    
    if (inputAmount > 0) {
      // number of dollars
      remainingAmount = (int)(inputAmount * 100);
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
    
      System.out.printf("'$%.2f' consists of:\n", inputAmount);
      if (dollars > 0) {
        System.out.printf("'%d' dollar%s\n", dollars, dollars > 1 ? "s" : "");
      }
      if (quarters > 0) {
        System.out.printf("'%d' quarter%s\n", quarters, quarters > 1 ? "s" : "");
      }
      if (dimes > 0) {
        System.out.printf("'%d' dime%s\n", dimes, dimes > 1 ? "s" : "");
      }
      if (nickels > 0) {
        System.out.printf("'%d' nickels\n", nickels);
      }
      if (pennies > 0) {
        System.out.printf("'%d' %s\n", pennies, pennies > 1 ? "pennies" : "penny");
      }
    }
  }
  
}
