package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter the timezone, and then the current time is displayed using a 12-hour clock at the given
 * timezone.
 */
public class Exercise3_30 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int zoneOffset;
    boolean isAM;
    long totalMiliseconds = System.currentTimeMillis();
    
    System.out.print("Enter zone offset: ");
    zoneOffset = input.nextInt();
    input.close();
    
    long totalSeconds = totalMiliseconds / 1000;
    long currentSeconds = totalSeconds % 60;
    long totalMinutes = totalSeconds / 60;
    long currentMinutes = totalMinutes % 60;
    long totalHours = totalMinutes / 60;
    long currentHours = (totalHours % 24) + zoneOffset;
    if (currentHours > 12) {
      isAM = false;
      currentHours -= 12;
    }
    else {
      isAM = currentHours != 12;
    }
    
    System.out.printf(
        "Current time (GMT%+d) is '%02d:%02d:%02d %s'\n",
        zoneOffset, currentHours, currentMinutes, currentSeconds, isAM ? "AM" : "PM"
    );
  }
  
}
