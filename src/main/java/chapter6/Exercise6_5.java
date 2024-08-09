package chapter6;

import java.util.Scanner;

/**
 * Sorts three numbers in increasing order and displays them.
 */
public class Exercise6_5 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter three integers: ");
    int intNumber1 = input.nextInt();
    int intNumber2 = input.nextInt();
    int intNumber3 = input.nextInt();
    input.close();

    displaySortedNumbers(intNumber1, intNumber2, intNumber3);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displaySortedNumbers(double num1, double num2, double num3) {
    if (num1 > num2) {
      if (num1 > num3) {
        System.out.printf("%.2f ", num1);
        if (num2 > num3) {
          System.out.printf("%.2f %.2f\n", num2, num3);
        }
        else {
          System.out.printf("%.2f %.2f\n", num3, num2);
        }
      }
      else {
        System.out.printf("%.2f %.2f %.2f\n", num3, num1, num2);
      }
    }
    else {
      if (num2 < num3) {
        System.out.printf("%.2f %.2f %.2f\n", num3, num2, num1);
      }
      else {
        if (num1 < num3) {
          System.out.printf("%.2f %.2f %.2f\n", num2, num3, num1);
        }
        else {
          System.out.printf("%.2f %.2f %.2f\n", num2, num1, num3);
        }
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
