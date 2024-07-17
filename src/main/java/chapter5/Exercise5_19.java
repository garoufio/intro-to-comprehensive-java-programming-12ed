package chapter5;

/**
 * Displays numbers in a pyramid pattern.
 */
public class Exercise5_19 {
  
  public final static int MAX_ROWS = 8;
  
  public static void main(String[] args) {
    int max; // max number to be printed in a row
    
    for (int i = 0; i < MAX_ROWS; i++) {
      max = (int)Math.pow(2, i);
      for (int j = 0; j < MAX_ROWS - i; j++) {
        System.out.printf("%5s", " ");
      }
      for (int j = 1; j < max; j = j * 2) {
        System.out.printf("%4d", j);
        if (j < max) System.out.printf("%s", " ");
      }
      for (int j = max; j > 0; j = j / 2) {
        System.out.printf("%4d", j);
        if (j > 1) System.out.printf("%s", " ");
      }
      System.out.println();
    }
  }
  
}
