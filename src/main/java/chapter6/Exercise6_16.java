package chapter6;

/**
 * Displays the number in a year from 2000 to 2020.
 */
public class Exercise6_16 {
  
  public static final int STARTING_YEAR               = 2000;
  public static final int ENDING_YEAR                 = 2020;
  public static final int NUMBER_OF_DAYS_IN_YEAR      = 365;
  public static final int NUMBER_OF_DAYS_IN_LEAP_YEAR = 366;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayTitle() {
    System.out.printf("%-10s%-20s\n", "Year", "Number of days");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayBody() {
    for (int i = STARTING_YEAR; i <= ENDING_YEAR; i++) {
      System.out.printf("%-10d%14d\n", i, numberOfDaysInAYear(i));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int numberOfDaysInAYear(int year) {
    return isLeapYear(year) ? NUMBER_OF_DAYS_IN_LEAP_YEAR : NUMBER_OF_DAYS_IN_YEAR;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    displayTitle();
    displayBody();
  }
  
}
