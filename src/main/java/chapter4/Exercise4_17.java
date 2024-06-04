package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter the year and the month (first three letters of a month name with the first letter in
 * uppercase), and then it displays the number of days in the month.
 */
public class Exercise4_17 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a year: ");
    int year = input.nextInt();
    if (year < 1900 || year > 9000) {
      System.out.println("Invalid year");
      System.exit(1);
    }
    System.out.print("Enter an month (the first three letters): ");
    String month = input.next();
    if (month.length() != 3) {
      System.out.println("Invalid month number of letters");
      System.exit(1);
    }
    input.close();
    
    boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    int days = switch (month) {
      case "Jan" -> 31;
      case "Feb" -> isLeapYear ? 29 : 28;
      case "Mar" -> 31;
      case "Apr" -> 30;
      case "May" -> 31;
      case "Jun" -> 30;
      case "Jul" -> 31;
      case "Aug" -> 31;
      case "Sep" -> 30;
      case "Oct" -> 31;
      case "Nov" -> 30;
      case "Dec" -> 31;
      default -> {
        System.out.printf("'%s' is not a correct month name\n", month);
        yield -1;
      }
    };
    
    if (days > 0) {
      System.out.printf("'%s %d' has '%d' days\n", month,  year, days);
    }
  }
  
}
