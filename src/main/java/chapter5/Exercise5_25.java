package chapter5;

/**
 * It approximates the π and displays the result.
 */
public class Exercise5_25 {
  
  public static void main(String[] args) {
    double pi;
    
    for (int i = 10_000; i <= 100_000; i += 10_000) {
      pi = 0;
      for (int j = 1; j <= i; j++) {
        pi += (Math.pow(-1, j + 1))/ ((2 * j) - 1);
      }
      pi = 4 * pi;
      System.out.printf("π for '%d' is '%f'\n", i, pi);
    }
    
  }
  
}
