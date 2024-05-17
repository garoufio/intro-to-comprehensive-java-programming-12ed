package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the wind chill temperature for a given outside temperature in Fahrenheit and wind speed in
 * miles per hour.
 */
public class Exercise2_17 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double windChillTemperature, otusideTemperature, windSpeed;
    
    System.out.print("Enter the temperature in Fahrenheit between -58F and 41F: ");
    otusideTemperature = input.nextDouble();
    System.out.print("Enter the wind speed (>=2) in miles per hour: ");
    windSpeed = input.nextDouble();
    input.close();
    
    windChillTemperature = 35.74 +
        (0.6215 * otusideTemperature) -
        (35.75 * Math.pow(windSpeed, 0.16)) +
        (0.4275 * otusideTemperature * Math.pow(windSpeed, 0.16));
    System.out.printf("The wind chill index is '%.2f'\n'", windChillTemperature);
  }
  
}
