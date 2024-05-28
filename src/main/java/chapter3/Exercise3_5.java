package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter today's day and the elapsed number of days since today and computes and displays
 * the future date.
 */
public class Exercise3_5 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int day, elapsedDays, futureDate;
    
    System.out.print("Enter today's day (0-6): ");
    day = input.nextInt();
    if (day < 0 || day > 6) {
      System.out.println("Invalid day");
      System.exit(1);
    }
    
    System.out.print("Enter the number of days elapsed since today: ");
    elapsedDays = input.nextInt();
    input.close();
    if (elapsedDays < 0) {
      System.out.println("Elapsed number of days must be a positive integer");
      System.exit(1);
    }
    
    futureDate = (day + elapsedDays) % 7;
    switch (futureDate) {
      case 0: System.out.printf("Monday (%d)\n", futureDate); break;
      case 1: System.out.printf("Tuesday (%d)\n", futureDate); break;
      case 2: System.out.printf("Wednesday (%d)\n", futureDate); break;
      case 3: System.out.printf("Thursday (%d)\n", futureDate); break;
      case 4: System.out.printf("Friday (%d)\n", futureDate); break;
      case 5: System.out.printf("Saturday (%d)\n", futureDate); break;
      case 6: System.out.printf("Sunday (%d)\n", futureDate); break;
      default: System.out.println("Invalid day");
    }
  }
  
}
