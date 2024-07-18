package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter the year and first day of the year, then displays the first day of each month in the year.
 */
public class Exercise5_28 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int year, firstDayOfYear;
    
    System.out.print("Enter the year [1000-2100]: ");
    year = input.nextInt();
    if (year < 1000 || year > 2100) {
      System.out.println("Invalid year");
      input.close();
      System.exit(1);
    }
    System.out.print("Enter the first day of the year [0-6] (0-Sunday...): ");
    firstDayOfYear = input.nextInt();
    
    if (firstDayOfYear <= 0 || firstDayOfYear > 6) {
      System.out.println("Invalid first day of the year");
      input.close();
      System.exit(1);
    }
    input.close();
    

    String month, day;
    int firsDayOfMonth = firstDayOfYear;
    int numberOfDaysInMonth;
    for (int i = 1; i <= 12; i++) {
      month = switch (i) {
        case 1 -> {
            numberOfDaysInMonth = 31;
            yield "January";
          }
        case 2 -> {
            // check if year is a leap year
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
              numberOfDaysInMonth = 29;
            }
            else {
              numberOfDaysInMonth = 28;
            }
            yield "February";
          }
        case 3 -> {
            numberOfDaysInMonth = 31;
            yield "March";
          }
        case 4 -> {
            numberOfDaysInMonth = 30;
            yield "April";
          }
        case 5 -> {
            numberOfDaysInMonth = 31;
            yield "May";
          }
        case 6 -> {
            numberOfDaysInMonth = 30;
            yield "June";
          }
        case 7 -> {
            numberOfDaysInMonth = 31;
            yield "July";
          }
        case 8 -> {
            numberOfDaysInMonth = 31;
            yield "August";
          }
        case 9 -> {
            numberOfDaysInMonth = 30;
            yield "September";
          }
        case 10 -> {
            numberOfDaysInMonth = 31;
            yield "October";
          }
        case 11 -> {
            numberOfDaysInMonth = 30;
            yield "November";
          }
        case 12 -> {
            numberOfDaysInMonth = 31;
            yield "December";
          }
        default -> {
            numberOfDaysInMonth = 0;
            yield "Invalid month";
          }
      };
      
      day = switch (firsDayOfMonth) {
        case 0 -> "Sunday";
        case 1 -> "Monday";
        case 2 -> "Tuesday";
        case 3 -> "Wednesday";
        case 4 -> "Thursday";
        case 5 -> "Friday";
        case 6 -> "Saturday";
        default -> "Invalid day";
      };
      System.out.printf("%s 1, %d is %s\n", month, year, day);
      
      firsDayOfMonth = (firsDayOfMonth + numberOfDaysInMonth) % 7;
    }
  }
  
}
