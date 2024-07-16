package chapter5;

/**
 * Displays prime numbers between 2 and 1000 (inclusive).
 */
public class Exercise5_20 {
  
  public static final int NUMBERS_PER_LINE = 8;
  public static final int MIN_NUMBER = 2;
  public static final int MAX_NUMBER = 1000;
  
  public static void main(String[] args) {
    int primeNumbersCount = 0;
    boolean isPrime;
    
    for (int i = MIN_NUMBER; primeNumbersCount <= MAX_NUMBER; i++) {
      isPrime = true;
      for (int j = i / 2; j > 1; j--) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        System.out.printf("%d ", i);
        primeNumbersCount++;
        if (primeNumbersCount % NUMBERS_PER_LINE == 0) {
          System.out.println();
        }
      }
    }
  }
  
}
