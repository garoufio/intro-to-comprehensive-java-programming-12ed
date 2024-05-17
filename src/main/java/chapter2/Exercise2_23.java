package chapter2;

import java.util.Scanner;

public class Exercise2_23 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double distance, fuelEfficiency, fuelPrice, costOfDriving;
    
    System.out.print("Enter the driving distance in miles: ");
    distance = input.nextDouble();
    System.out.print("Enter fuel efficiency in miles per gallon: ");
    fuelEfficiency = input.nextDouble();
    System.out.print("Enter fuel price per gallon: ");
    fuelPrice = input.nextDouble();
    input.close();
    
    costOfDriving = fuelPrice * (distance / fuelEfficiency);
    System.out.printf("The cost of driving is '$%.2f'\n", costOfDriving);
  }
  
}
