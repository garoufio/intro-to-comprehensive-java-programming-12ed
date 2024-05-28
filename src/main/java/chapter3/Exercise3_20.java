package chapter3;

import java.util.Scanner;

/**
 * Calculates and displays the wind chill temperature for a given outside temperature in Fahrenheit and wind speed in
 * miles per hour.
 */
public class Exercise3_20 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double windChillTemperature, outsideTemperature, windSpeed;
    
    System.out.print("Enter the temperature in Fahrenheit between -58F and 41F: ");
    outsideTemperature = input.nextDouble();
    if (outsideTemperature < -58 || outsideTemperature > 41) {
      System.out.println("Invalid outside temperature");
      System.exit(1);
    }
    
    System.out.print("Enter the wind speed (>=2) in miles per hour: ");
    windSpeed = input.nextDouble();
    if (windSpeed < 2) {
      System.out.println("Invalid wind speed");
      System.exit(1);
    }
    input.close();
    
    windChillTemperature = 35.74 +
        (0.6215 * outsideTemperature) -
        (35.75 * Math.pow(windSpeed, 0.16)) +
        (0.4275 * outsideTemperature * Math.pow(windSpeed, 0.16));
    System.out.printf("The wind chill index is '%.2f'\n", windChillTemperature);
  }
  
}
