package chapter5;

/**
 * Displays all possible combinations for picking two numbers from integers 1 to 7. Then it displays the total number
 * of all combinations.
 */
public class Exercise5_43 {
  
  public static void main(String[] args) {
    int count = 0;
    
    for (int i = 1; i <= 7; i++) {
      for (int j = 1; j <= 7; j++) {
        if (i >= j) continue;
        
        System.out.printf("%d %d\n", i, j);
        count++;
      }
    }
    System.out.printf("The total number of all combinations is: %d\n", count);
  }
  
}
