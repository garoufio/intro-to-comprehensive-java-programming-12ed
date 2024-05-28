package chapter3;

import java.util.Scanner;

public class Exercise3_11 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int month, year;
    
    System.out.print("Enter month and year: ");
    month = input.nextInt();
    year = input.nextInt();
    input.close();
    if (month < 1 || month > 12) {
      System.out.println("Invalid month");
      System.exit(1);
    }
    if (year < 1900 || year > 2200) {
      System.out.println("Invalid year");
      System.exit(1);
    }
    
    boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    switch (month) {
      case 1:
        System.out.printf("January %d has 31 days", year);
        break;
      case 2:
        System.out.printf("February %d has %d days\n", year, isLeapYear ? 29 : 28);
        break;
      case 3:
        System.out.printf("March %d has 31 days", year);
        break;
      case 4:
        System.out.printf("April %d has 30 days", year);
        break;
      case 5:
        System.out.printf("May %d has 31 days", year);
        break;
      case 6:
        System.out.printf("June %d has 30 days", year);
        break;
      case 7:
        System.out.printf("July %d has 31 days", year);
        break;
      case 8:
        System.out.printf("August %d has 31 days", year);
        break;
      case 9:
        System.out.printf("September %d has 30 days", year);
        break;
      case 10:
        System.out.printf("October %d has 31 days", year);
        break;
      case 11:
        System.out.printf("November %d has 30 days", year);
        break;
      case 12:
        System.out.printf("December %d has 31 days", year);
        break;
    }
  }
  
}
