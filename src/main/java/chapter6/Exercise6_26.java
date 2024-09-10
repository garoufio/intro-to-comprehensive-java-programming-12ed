package chapter6;

/**
 * Displays the first 100 palindromic prime numbers.
 */
public class Exercise6_26 {
  
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
  
  public static boolean isPalindrome(int number) {
//    String str = String.valueOf(number);
//
//    for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
//      if (str.charAt(i) != str.charAt(j)) return false;
//    }
    
    // reverse the number
    int num = number;
    int reverse = 0;
    while (num != 0) {
      reverse = (reverse * 10) + (num % 10);
      num /= 10;
    }
    
    return number == reverse;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printPalindromicPrimeNumbers() {
    for (int i = 1, count = 0; i <= NUMBERS_TO_PRINT; i++) {
      if (isPrime(i) && isPalindrome(i)) {
        System.out.print(i);
        count++;
        
        if (count > 0 && count % NUMBERS_PER_LINE == 0) System.out.println();
        else System.out.print(" ");
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    printPalindromicPrimeNumbers();
  }
  
}
