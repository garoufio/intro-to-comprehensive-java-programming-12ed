package chapter5;

/**
 * Computes the following summation:
 *  1 / (1 + sqrt(2)) + 1 / (sqrt(2) + sqrt(3)) + 1 / (sqrt(3) + sqrt(4)) + ... + 1 / (sqrt(624) + sqrt(625))
 */
public class Exercise5_35 {
  
  public static void main(String[] args) {
    double sum = 0;
    for (int i = 1; i < 625; i++) {
      sum += 1 / (Math.sqrt(i) + Math.sqrt(i + 1));
    }
    System.out.printf("The result is '%.3f'\n", sum);
  }
  
}
