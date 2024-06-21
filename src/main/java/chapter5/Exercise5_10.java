package chapter5;

/**
 * Finds and displays all numbers that are divisible by 5 and 6.
 */
public class Exercise5_10 {
  
  public static final int NUMBERS_PER_LINE = 10;
  public static final int STARTING_NUMBER = 100;
  public static final int ENDING_NUMBER = 1000;
  
  public static void main(String[] args) {
    int count = 0;
    
    for (int i = STARTING_NUMBER; i <= ENDING_NUMBER; i++) {
      if (i % 5 == 0 && i % 6 == 0) {
        System.out.printf("%d ", i);
        count++;
        if (count % NUMBERS_PER_LINE == 0) System.out.println();
      }
    }
  }
  
}
