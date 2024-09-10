package chapter6;

/**
 * Finds and displays all twin primes less than 1000. Twin primes are a pair of primes that differ by 2. For example,
 * 3 and 5 are twin primes, 5 and 7 are twin primes.
 */
public class Exercise6_29 {
  
  public static final int MAX_PRIME_NUMBER = 1000;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isPrime(int number) {
    if (number < 2) return false;
    
    for (int i = 2; i <= number / 2; i++) {
      for (int j = i; j > 1; j--) {
        if (number % j == 0) return false;
      }
    }
    
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printTwinPrimes() {
    for (int i = 1, j = 1; i < MAX_PRIME_NUMBER && j <= MAX_PRIME_NUMBER; i++, j = i + 2) {
      if (isPrime(i) && isPrime(j) && j - i == 2) {
        System.out.printf("(%d, %d)\n", i, j);
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    printTwinPrimes();
  }
  
}
