package chapter6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Prints calendar using the Zeller's congruence to calculate the day of the week.
 */
public class Exercise6_34 {
  
  public static final int START_DAY_OF_1_JANUARY_1800 = 3; // Wednesday
  public static final int NUMBER_OF_DAYS_IN_YEAR = 365;
  public static final int NUMBER_OF_DAYS_IN_LEAP_YEAR = 366;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValid(int value, int from, int to) {
    return (value >= from && value <= to);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidMonth(int month) {
    return (month == 0 || isValid(month,1, 12));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidYear(int year) {
    return (year == 0 || isValid(year, 1800, 2100));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * Prompts the user to enter the month [1-12]. For exiting, 0 must be entered.
   * @param sc a Scanner object.
   * @return an int value with the year entered by the user. -1 is returned if the year entered is invalid.
   */
  public static int readMonth(Scanner sc) {
    int month = -1;
    
    System.out.print("Enter month (1: January, 2: February, ..., 12: December, 0: quit): ");
    try {
      month = sc.nextInt();
      if (!isValidMonth(month)) {
        System.out.println("Invalid month");
        month = -1;
      }
      
      // according to the algorithm, January (1) and February (2) are counted as 13 and 14.
      switch (month) {
        case 1: month = 13; break;
        case 2: month = 14; break;
      }
    }
    catch (InputMismatchException e) {
      System.out.println("Invalid month");
      sc.nextLine();
    }
    
    return month;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * Prompts the user to enter the year between 1800 and 2100. For exiting, 0 must be entered.
   * @param sc a Scanner object.
   * @return an int value with the year entered by the user. -1 is returned if the year entered is invalid.
   */
  public static int readYear(Scanner sc) {
    int year = -1;
    
    System.out.print("Enter year [1800-2100], 0: quit: ");
    try {
      year = sc.nextInt();
      if (!isValidYear(year)) {
        System.out.println("Invalid year");
        year = -1;
      }
    }
    catch (InputMismatchException e) {
      System.out.println("Invalid year");
      sc.nextLine();
    }
    
    return year;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * Checks whether the given year is a leap year or not.
   * @param year  an int with values from 1800 up to 2100.
   * @return a boolean value indicating whether the given year is a leap year or not.
   */
  public static boolean isLeapYear(int year) {
    return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * Returns the name of the month.
   * @param month an int value of the month (13: January, 14: February, 3: March, ..., 12: December).
   * @return a string with the name of the month. If the int value is out of range, "Unknown" is returned.
   */
  public static String getMonthName(int month) {
    return switch (month) {
      case 13 -> "January";
      case 14 -> "February";
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
      default -> "Unknown";
    };
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * Computes the total number of days in month.
   * @param month an int with values from 3 to 14 (13: January, 14: February, 3: March, ..., 12: December).
   * @param year an int with values from 1800 up to 2100.
   * @return an int value with the total number of days in month.
   */
  public static int getNumberOfDaysInMonth(int month, int year) {
    return switch(month) {
      case 3, 5, 7, 8, 10, 12, 13 -> 31;
      case 4, 6, 9, 11 -> 30;
      case 14 -> isLeapYear(year) ? 29 : 28;
      default -> -1;
    };
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * Returns the first day of the week.
   * @param month  an int with values from 3 to 14 (13: January, 14: February, 3: March, ..., 12: December).
   * @param year an int with values from 1800 up to 2100.
   * @param dayOfMonth an int value with values from 1 to 31.
   * @return an int value with the number of day in the week.
   */
  public static int getDayOfWeek(int month, int year, int dayOfMonth) {
    if (month == 13 || month == 14) {
      year--;
    }
    
    int k = year % 100;
    int j = (int)(year / 100);
    
    int dayOfWeek = (int)(dayOfMonth + (int)((month + 1) * 26.0 / 10)
        + k + (int)(k / 4.0) + (int)(j / 4.0) + 5 * j) % 7;
    
    return (dayOfWeek + 6) % 7;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * Returns the starting day of the first week of the given month and year.
   * @param month an int with values from 1 to 12 (1: January, ..., 12: December).
   * @param year  an int with values from 1800 up to 2100.
   * @return an int value indicating the starting day of the first week of the given month and year.
   */
  public static int getStartDay(int month, int year) {
    return getDayOfWeek(month, year, 1);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printMonthBody(int month, int year) {
    int daysWritten = 0;
    int daysCount = 0;
    int numberOfDaysInMonth = getNumberOfDaysInMonth(month, year);
    int firsDayOfMonth = getStartDay(month, year);
    
    while (daysWritten < numberOfDaysInMonth) {
      if (daysCount != 0 && daysCount % 7 == 0) System.out.println();
      
      if (daysCount >= firsDayOfMonth) {
        System.out.printf("%-6d", daysWritten + 1);
        daysWritten++;
      }
      else {
        System.out.printf("%-6s", " ");
      }
      
      daysCount++;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printMonthTitle(int month, int year) {
    System.out.printf("\n%s %d\n", getMonthName(month), year);
    System.out.println("----------------------------------------");
    System.out.printf(
        "%-6s%-6s%-6s%-6s%-6s%-6s%-6s\n",
        "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printMonth(int month, int year) {
    printMonthTitle(month, year);
    printMonthBody(month, year);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int year, month;
    
    Scanner input = new Scanner(System.in);
    
    do {
      year = readYear(input);
    } while (year == -1);
    if (year == 0) {
      System.out.println("Exit...");
      System.exit(-1);
      input.close();
    }
    
    do {
      month = readMonth(input);
    } while (month == -1);
    if (month == 0) {
      System.out.println("Exit...");
      System.exit(-1);
      input.close();
    }
    input.close();
    
    printMonth(month, year);
  }
  
}
