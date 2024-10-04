package chapter7;

/**
 * Computes and displays the first 50 prime numbers. In order to check whether a number is prime or not, the following
 * algorithm is used: check whether any of the prime numbers less than or equal to Math.sqrt(n) can divide n evenly.
 * If not, n is prime.
 */
public class Exercise7_6 {
  
  public static final int MAX_NUMBER_OF_PRIMES = 50;
  public static final int NUMBERS_PER_LINE = 10;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int[] primeNumbers = getPrimeNumbers(MAX_NUMBER_OF_PRIMES);
    displayPrimeNumbers(primeNumbers);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getPrimeNumbers(int numberOfPrimes) {
    int[] primeNumbers = new int[numberOfPrimes];
    int countPrimeNumbers = 0;
    int number = 2;
    boolean isPrime;
    
    while (countPrimeNumbers < numberOfPrimes) {
      isPrime = true;
      
      for (int i = 0; (i < countPrimeNumbers) && (primeNumbers[i] <= Math.sqrt(number)); i++) {
        if (number % primeNumbers[i] == 0) {
          isPrime = false;
          break;
        }
      }
      
      if (isPrime) {
        primeNumbers[countPrimeNumbers] = number;
        countPrimeNumbers++;
      }
      
      number++;
    }
    return primeNumbers;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayPrimeNumbers(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      if (i != 0 && i % NUMBERS_PER_LINE == 0) System.out.println();
      
      System.out.printf("%8d", numbers[i]);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
