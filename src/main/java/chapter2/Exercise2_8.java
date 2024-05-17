package chapter2;

import java.util.Scanner;

/**
 * Displays the current time for a given zone offset.
 */
public class Exercise2_8 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int zoneOffset;
    long totalMiliseconds = System.currentTimeMillis();
    
    System.out.print("Enter zone offset: ");
    zoneOffset = input.nextInt();
    input.close();
    
    long totalSeconds = totalMiliseconds / 1000;
    long currentSeconds = totalSeconds % 60;
    long totalMinutes = totalSeconds / 60;
    long currentMinutes = totalMinutes % 60;
    long totalHours = totalMinutes / 60;
    long currentHours = (totalHours % 24);
    
    System.out.printf(
        "Current time (GMT%+d) is '%02d:%02d:%02d'\n",
        zoneOffset, currentHours + zoneOffset, currentMinutes, currentSeconds
    );
  }
  
}
