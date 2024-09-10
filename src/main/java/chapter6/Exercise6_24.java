package chapter6;

import java.time.LocalDate;

/**
 * Displays current date and time.
 */
public class Exercise6_24 {
  
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
    int month = date.getMonthValue();
    int year = date.getYear();
    System.out.printf("Current date time is: %d/%d/%d - %d:%d:%d GMT\n", year, month, day, hour, minutes, seconds);
  }

}
