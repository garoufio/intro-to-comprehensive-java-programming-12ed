package chapter6;

/**
 * Finds all Mersenne primes with p <= 31 and displays them. A prime number is called Mersenne if it can be written in
 * the form 2^p - 1 for some positive p.
 */
public class Exercise6_28 {
  
  public static final int NUMBERS_TO_PRINT = 31;
  public static final int NUMBERS_PER_LINE = 10;
  
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
  
  public static boolean isMersenne(int number) {
    return isPrime(number) && isPrime((int)(Math.pow(2, number) - 1));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printMersenne() {
    for (int i = 1, count = 0; i <= NUMBERS_TO_PRINT; i++) {
      if (isMersenne(i)) {
        System.out.print(i);
        count++;
        
        if (count > 0 && count % NUMBERS_PER_LINE == 0) System.out.println();
        else System.out.print(" ");
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    printMersenne();
  }
  
}
