package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter a long integer for milliseconds. The program converts the milliseconds to hours, minutes
 * and seconds and displays a string in the format hh:mm:ss.
 */
public class Exercise6_25 {
  
  public static void printResult(long milliseconds) {
    long remainingTime;
    
    remainingTime = milliseconds / 1000;
    int seconds = (int) (remainingTime % 60);
    remainingTime /= 60;
    int minutes = (int) (remainingTime % 60);
    int hours = (int)(remainingTime / 60);
    
    System.out.printf("%d:%d:%d\n", hours, minutes, seconds);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static long readMilliseconds(Scanner scanner) {
    long milliseconds = 0;
    
    do {
      System.out.print("Enter milliseconds (greater than or equal to 0): ");
      milliseconds = scanner.nextLong();
      if (milliseconds < 0) {
        System.out.println("Invalid milliseconds entered.");
      }
    } while (milliseconds < 0);
    
    return milliseconds;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long milliseconds = readMilliseconds(input);
    input.close();
    
    printResult(milliseconds);
  }
  
}
