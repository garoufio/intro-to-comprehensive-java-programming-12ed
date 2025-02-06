package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter the exchange rate is US dollars to Chinese RMB, prompt the user to select 0 in order to
 * convert from US dollars to Chinese RMB or 1 to convert Chinese RMB to US dollars. Then, prompt the user to enter the
 * amount he/she want to convert in US dollars or Chinese RMB respectively.
 */
public class Exercise3_31 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double exchangeRate, fromAmount, toAmount;
    boolean exchangeToUSDollars;
    
    System.out.print("Enter exchange rate from dollars to RMB: ");
    exchangeRate = input.nextDouble();
    if (Math.abs(exchangeRate) <= 1E-14) {
      input.close();
      throw new IllegalStateException("Exchange rate must be greater than 0");
    }
    System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
    int choice = input.nextInt();
    exchangeToUSDollars = switch (choice) {
      case 0 -> true;
      case 1 -> false;
      default -> {
        input.close();
        throw new IllegalStateException("Invalid choice " + choice);
      }
    };
    System.out.print("Enter the amount to be converted: ");
    fromAmount = input.nextDouble();
    input.close();
    
    if (exchangeToUSDollars) {
      toAmount = fromAmount * exchangeRate;
      System.out.printf("'$%.2f' is '%.2f' yuan\n", fromAmount, toAmount);
    }
    else {
      toAmount = fromAmount / exchangeRate;
      System.out.printf("'%.2f' yuan is '$%.2f'\n", fromAmount, toAmount);
    }
  }
  
}
