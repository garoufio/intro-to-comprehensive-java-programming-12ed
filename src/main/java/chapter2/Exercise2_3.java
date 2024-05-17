package chapter2;

import java.util.Scanner;

/**
 * Converts feet into meters and displays the result.
 */
public class Exercise2_3 {
  
  public static final double FOOT_TO_METER = 0.305;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double feet, meters;
    
    System.out.print("Enter feet: ");
    feet = input.nextDouble();
    input.close();
    
    meters = feet * FOOT_TO_METER;
    System.out.printf("'%.2f' feet are '%.2f' meters\n", feet, meters);
  }
  
}
