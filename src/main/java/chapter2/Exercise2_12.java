package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the minimum runaway length needed for an airplane to take off for a given airplane's
 * acceleration and take-off speed in meters/second.
 */
public class Exercise2_12 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double acceleration, speed, length;
    
    System.out.print("Enter speed and acceleration: ");
    speed = input.nextDouble();
    acceleration = input.nextDouble();
    input.close();
    
    length = Math.pow(speed, 2) / (2 * acceleration);
    System.out.printf("The minimum runaway length for this airplane is '%.2f' meters\n", length);
  }
  
}
