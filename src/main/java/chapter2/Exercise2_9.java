package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the average acceleration for a given time span in seconds and
 * starting and ending velocities in meters/second.
 */
public class Exercise2_9 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double startingVelocity, endingVelocity, acceleration, time;
    
    System.out.print("Enter starting and ending velocity in meters/second: ");
    startingVelocity = input.nextDouble();
    endingVelocity = input.nextDouble();
    System.out.print("Enter time span in seconds: ");
    time = input.nextDouble();
    input.close();
    
    if (time != 0) {
      acceleration = (endingVelocity - startingVelocity) / time;
      System.out.printf("The average acceleration is '%0.2f'\n", acceleration);
    }
    else {
      System.out.println("Time span cannot be zero");
    }
  }
  
}
