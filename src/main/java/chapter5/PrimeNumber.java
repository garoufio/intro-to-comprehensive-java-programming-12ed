package chapter5;

/**
 * Displays the first 50 prime numbers in 5 lines.
 */
public class PrimeNumber {
  
  public static final int NUMBER_OF_PRIMES = 50;
  public static final int NUMBER_OF_PRIMES_PER_LINE = 10;
  
  public static void main(String[] args) {
    int primeNumbersCount = 0;
    boolean isPrime;
    
    for (int i = 2; primeNumbersCount < NUMBER_OF_PRIMES; i++) {
      isPrime = true;
      for (int j = i / 2; j > 1; j--) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        System.out.printf("%4d", i);
        primeNumbersCount++;
        if (primeNumbersCount % NUMBER_OF_PRIMES_PER_LINE == 0) {
          System.out.println();
        }
      }
    }
  }
  
}
