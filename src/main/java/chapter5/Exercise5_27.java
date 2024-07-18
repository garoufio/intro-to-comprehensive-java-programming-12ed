package chapter5;

/**
 * Displays all the leap years, 10 per line, from 101 to 2100, separated by exactly one space. Also, displays the
 * number of leap years in this period.
 */
public class Exercise5_27 {
  
  public static final int FROM_YEAR = 101;
  public static final int TO_YEAR = 2100;
  public static final int YEARS_PER_LINE = 10;
  
  public static void main(String[] args) {
    int numberOfLeapYears = 0;
    
    for (int i = FROM_YEAR; i <= TO_YEAR; i++) {
      if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
        numberOfLeapYears++;
        System.out.print(i);
        if (numberOfLeapYears % 10 == 0) {
          System.out.println();
        }
        else {
          System.out.print(" ");
        }
      }
    }
  }
  
}
