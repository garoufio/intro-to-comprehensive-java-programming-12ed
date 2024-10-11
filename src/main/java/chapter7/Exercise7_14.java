package chapter7;

import java.util.Arrays;

/**
 * Calculates and displays the greatest common divisor of numbers [2, 4, 24, 100]
 */
public class Exercise7_14 {
  
  public static void main(String[] args) {
    int[] numbers = { 2, 4, 24, 100 };
    
    System.out.printf(
        "The greatest common divisor of '%s' is '%d'\n",
          Arrays.toString(numbers), gcd(numbers)
        );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int gcd(int... numbers) {
    int gcd = 1;
    int k = gcd;
    
    while (checkSmallest(k, numbers)) {
      if (checkModulo(k, numbers)) {
        gcd = k;
      }
      k++;
    }
    return gcd;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkSmallest(int number, int... numbers) {
    boolean isSmallest = true;
    
    for (int n : numbers) {
      if (number > n) return false;
    }
    return isSmallest;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkModulo(int number, int... numbers) {
    boolean isModulo = true;
    
    for (int n : numbers) {
      if (n % number != 0) return false;
    }
    return isModulo;
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
