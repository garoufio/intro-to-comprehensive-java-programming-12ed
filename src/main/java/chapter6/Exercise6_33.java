package chapter6;

import java.time.LocalDate;

/**
 * Displays the current date and time.
 */
public class Exercise6_33 {
  
  public static void main(String[] args) {
    long currentTime = System.currentTimeMillis();
    long remainingTime;
    
    remainingTime = currentTime / 1000;
    int seconds = (int)(remainingTime % 60);
    remainingTime = remainingTime / 60;
    int minutes = (int)(remainingTime % 60);
    remainingTime = remainingTime / 60;
    int hour = (int)(remainingTime % 24);
    
    LocalDate date = LocalDate.now();
    int day = date.getDayOfMonth();
    String month = date.getMonth().toString().toLowerCase();
    month = (month.charAt(0) + "").toUpperCase() + month.substring(1);
    int year = date.getYear();
    System.out.printf("Current date and time is %s %d, %d - %d:%d:%d GMT\n", month, day, year, hour, minutes, seconds);
  }
  
}
