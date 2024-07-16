package chapter5;

/**
 * Displays four patterns using loops.
 */
public class Exercise5_18 {
  
  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 6;
  
  public static void main(String[] args) {
    // pattern A
    System.out.println("#### Pattern A ####");
    for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
      for (int j = MIN_NUMBER; j <= i; j++) {
        System.out.printf("%d", j);
        if (j < i) System.out.print(" ");
      }
      System.out.println();
    }
    
    // pattern B
    System.out.printf("\n#### Pattern B ####\n");
    for (int i = MIN_NUMBER, count = 1; i <= MAX_NUMBER; i++, count++) {
      for (int j = MIN_NUMBER; j <= MAX_NUMBER + 1 - count; j++) {
        System.out.printf("%d", j);
        if (j < MAX_NUMBER) System.out.print(" ");
      }
      System.out.println();
    }
    
    // pattern C
    System.out.printf("\n#### Pattern C ####\n");
    for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
      for (int j = MAX_NUMBER; j >= MIN_NUMBER; j--) {
        if (j <= i) {
          System.out.printf("%d", j);
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    
    // pattern D
    System.out.printf("\n#### Pattern D ####\n");
    for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
      for (int j = MIN_NUMBER, k = MIN_NUMBER; j <= MAX_NUMBER; j++) {
        if (j >= i) {
          System.out.printf("%d", k++);
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
  
}
