package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter the year and first day of the year and displays the calendar table for the year on the
 * console.
 */
public class Exercise5_29 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int year;
    int firstDayOfYear;
    
    System.out.print("Enter the year [1000-2100]: ");
    year = input.nextInt();
    if (year < 1000 || year > 2100) {
      System.out.println("Invalid year");
      System.exit(1);
      input.close();
    }
    System.out.print("Enter first day of year [0-6] (0-Sunday...): ");
    firstDayOfYear = input.nextInt();
    if (firstDayOfYear < 0 || firstDayOfYear > 6) {
      System.out.println("Invalid first day of year");
      System.exit(1);
      input.close();
    }
    input.close();
    
    String month, day;
    int firsDayOfMonth = firstDayOfYear;
    int numberOfDaysInMonth, daysWritten, daysCount;
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
      System.out.printf("\n\n%s %d\n", month, year);
      System.out.println("----------------------------------------");
      System.out.printf(
          "%-6s%-6s%-6s%-6s%-6s%-6s%-6s\n",
          "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
      );
      
      daysWritten = 0;
      daysCount = 0;
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
      firsDayOfMonth = (firsDayOfMonth + numberOfDaysInMonth) % 7;
    }
  }
  
}
