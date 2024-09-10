package chapter6;

/**
 * Displays the first 100 emirps (a non-palindromic number whose reversal is also a prime).
 */
public class Exercise6_27 {
  
  public static final int NUMBERS_TO_PRINT = 100;
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
  
  public static int getReverse(int number) {
    // reverse the number
    int num = number;
    int reverse = 0;
    while (num != 0) {
      reverse = (reverse * 10) + (num % 10);
      num /= 10;
    }
    
    return reverse;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isPalindrome(int number) {
    return number == getReverse(number);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printEmirp() {
    for (int i = 1, count = 0; i <= NUMBERS_TO_PRINT; i++) {
      if (isPrime(i) && !isPalindrome(i) && isPrime(getReverse(i))) {
        System.out.print(i);
        count++;
        
        if (count > 0 && count % NUMBERS_PER_LINE == 0) System.out.println();
        else System.out.print(" ");
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    printEmirp();
  }
  
}
