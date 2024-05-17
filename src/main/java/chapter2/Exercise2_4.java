package chapter2;

import java.util.Scanner;

/**
 * Converts pounds into kilograms and displays the result.
 */
public class Exercise2_4 {
  
  public static final double POUND_TO_KG = 0.454;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double pounds, kilograms;
    
    System.out.print("Enter pounds: ");
    pounds = input.nextDouble();
    input.close();
    
    kilograms = pounds * POUND_TO_KG;
    System.out.printf("'%.2f' pounds are '%.2f' kilograms\n", pounds, kilograms);
  }
  
}
