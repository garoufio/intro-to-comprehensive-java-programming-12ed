package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the energy needed to heat water from an initial temperature to a final temperature in Celsius
 * for a given weight of water in kilograms.
 */
public class Exercise2_10 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double initialTemperature, finalTemperature, waterWeight, energy;
    
    System.out.print("Enter the amount of water in kilograms: ");
    waterWeight = input.nextDouble();
    System.out.print("Enter the initial temperature in Celsius: ");
    initialTemperature = input.nextDouble();
    System.out.print("Enter the final temperature in Celsius: ");
    finalTemperature = input.nextDouble();
    input.close();
    
    energy = waterWeight * (finalTemperature - initialTemperature) * 4184;
    System.out.printf("The energy needed is '%.2f' Joules\n", energy);
  }
  
}
