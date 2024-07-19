package chapter5;

import java.util.Scanner;

public class Exercise5_42 {
  
  public static final double BASE_SALARY = 5000;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double commisionSought;
    
    System.out.print("Enter commision sought: ");
    commisionSought = input.nextDouble();
    input.close();
    if (commisionSought < BASE_SALARY) {
      System.out.println("Commision sought is less than base salary");
      System.exit(1);
    }
    
    double salesAmount = 0;
    double commission;
    for (;;) {
      commission = 0;
      if (salesAmount >= 0.01 && salesAmount <= 5000) {
        commission += salesAmount * 0.08;
      }
      else if (salesAmount >= 5000.01 && salesAmount <= 10000) {
        commission += salesAmount * 0.1;
      }
      else {
        commission += salesAmount * 0.12;
      }
      salesAmount += 0.1;
      
      if (commission + BASE_SALARY >= commisionSought) break;
    }
    System.out.printf(
        "The minimum sales amount in order to make '$%.2f' is '$%.2f'\n",
        commisionSought, salesAmount
    );
  }
  
}
