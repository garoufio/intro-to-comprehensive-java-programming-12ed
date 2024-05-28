package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter his/her weight in pounds, height in feet and inches and computes and displays the BMI.
 */
public class Exercise3_6 {
  
  public static final double POUND_TO_KILOGRAM = 0.45359237;
  public static final double FOOT_TO_METER = 0.3048;
  public static final double INC_TO_METER = 0.0254;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double weight, feet, inches, bmi;
    
    System.out.print("Enter weight in pounds: ");
    weight = input.nextDouble();
    System.out.print("Enter feet: ");
    feet = input.nextDouble();
    System.out.print("Enter inches: ");
    inches = input.nextDouble();
    input.close();
    
    bmi = (weight * POUND_TO_KILOGRAM) / Math.pow((feet * FOOT_TO_METER) + (inches * INC_TO_METER), 2);
    System.out.printf("BMI is '%f'\n", bmi);
    if (bmi < 18.5) {
      System.out.println("Underweight");
    }
    else if (bmi < 25) {
      System.out.println("Normal");
    }
    else if (bmi < 40) {
      System.out.println("Overweight");
    }
    else {
      System.out.println("Obese");
    }
  }
  
}
