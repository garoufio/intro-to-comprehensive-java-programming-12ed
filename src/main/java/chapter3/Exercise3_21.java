package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter a year, month, day of the month, and it computes the day of the week according to the
 * Zeller's congruence algorithm.
 */
public class Exercise3_21 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the year (1900-2200): ");
    int year = input.nextInt();
    if (year < 1900 || year > 2200) {
      System.out.println("Invalid year");
      System.exit(1);
    }
    System.out.print("Enter the month (1-12): ");
    int month = input.nextInt();
    if (month < 1 || month > 12) {
      System.out.println("Invalid month");
      System.exit(1);
    }
    
    // according to the algorithm, January (1) and February (2) are counted as 13 and 14.
    switch (month) {
      case 1: month = 13; break;
      case 2: month = 14; break;
    }
    System.out.print("Enter the day of the month (1-31): ");
    int dayOfMonth = input.nextInt();
    input.close();
    
    boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    int maxDays;
    maxDays = switch (month) {
      case 14 -> isLeapYear ? 29 : 28;
      case 3, 5, 7, 8, 10, 12, 13 -> 31;
      case 4, 6, 9, 11 -> 30;
      default -> 0;
    };
    if (dayOfMonth < 1 || dayOfMonth > maxDays) {
      String monthString = switch(month) {
        case 3 -> "March";
        case 4 -> "April";
        case 5 -> "May";
        case 6 -> "June";
        case 7 -> "July";
        case 8 -> "August";
        case 9 -> "September";
        case 10 -> "October";
        case 11 -> "November";
        case 12 -> "December";
        case 13 -> "January";
        case 14 -> "February";
        default -> throw new IllegalStateException("Invalid month: " + month);
      };
      System.out.printf("Invalid number of days. '%s' has '%d' days\n", monthString, maxDays);
      System.exit(1);
    }
    
    int century = year % 100;
    int dayOfWeek = (
        dayOfMonth + ((26 * (month + 1)) / 10) + century + century / 4 + (year / 100) / 4 + (5 * (year / 100))
    ) % 7;
    String dayOfWeekString = switch (dayOfWeek) {
      case 0 -> "Saturday";
      case 1 -> "Sunday";
      case 2 -> "Monday";
      case 3 -> "Tuesday";
      case 4 -> "Wednesday";
      case 5 -> "Thursday";
      case 6 -> "Friday";
      default -> throw new IllegalStateException("Invalid day of week: " + dayOfWeek);
    };
    System.out.printf("Day of week is '%s'\n", dayOfWeekString);
  }

}
