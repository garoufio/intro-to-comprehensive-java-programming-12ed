package chapter2;

import java.util.Scanner;

/**
 * Computes and displays the BMI for a given weight in pounds and heigth in inches.
 */
public class Exercise2_14 {
  
  public static final double POUND_TO_KILOGRAM = 0.45359237;
  public static final double INCH_TO_METER = 0.0254;
  
  public static void main(String[] args) {
    Scanner input =  new Scanner(System.in);
    double weight, height, bmi;
    
    System.out.print("Enter weight in pounds: ");
    weight = input.nextDouble();
    System.out.print("Enter height in inches: ");
    height = input.nextDouble();
    input.close();
    
    bmi = weight * POUND_TO_KILOGRAM / Math.pow(height * INCH_TO_METER, 2);
    System.out.printf("BMI is '%.2f'", bmi);
  }
  
}
