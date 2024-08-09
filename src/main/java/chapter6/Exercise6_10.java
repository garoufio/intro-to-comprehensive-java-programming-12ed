package chapter6;

/**
 * Finds the number of prime numbers less than 10000.
 */
public class Exercise6_10 {
  
  public static final int MAX_NUMBER = 10000;
  
  public static void main(String[] args) {
    int countPrimes = 0;
    
    for (int i = 1; i <= MAX_NUMBER; i++) {
      if (isPrime(i)) countPrimes++;
    }
    
    System.out.printf("'%d' prime numbers found up to '%d'\n", countPrimes, MAX_NUMBER);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isPrime(int number) {
    boolean isPrime = number > 1 ? true : false;
    
    for (int i = number / 2; i > 1; i--) {
      if (number % i == 0) {
        isPrime = false;
        break;
      }
    }

    return isPrime;
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
