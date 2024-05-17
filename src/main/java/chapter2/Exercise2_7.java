package chapter2;

import java.util.Scanner;

/**
 * Finds the number of years for a given number of minutes and displays the result.
 */
public class Exercise2_7 {
  
  public static final int MINUTES_PER_YEAR = 365 * 24 * 60;
  public static final int MINUTES_PER_DAY = 24 * 60;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long minutes;
    
    System.out.print("Enter the number of minutes: ");
    minutes = input.nextLong();
    input.close();
    
    if (minutes < 0) {
      System.out.println("Invalid number of minutes");
    }
    else {
      int years, days;
      
      
      years = (int)(minutes / MINUTES_PER_YEAR);
      days = (int)((minutes % MINUTES_PER_YEAR) / MINUTES_PER_DAY);
      System.out.printf("'%d' minutes are approximately '%d' years and '%d' days\n", minutes, years, days);
    }
  }
  
}
