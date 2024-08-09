package chapter6;

/**
 * Calculates the sum of the digits of an integer number and displays the result.
 */
public class Exercise6_2 {
  
  public static void main(String[] args) {
    System.out.printf("The sum of '%d' is '%d'\n", 234, sumDigits(234));
    System.out.printf("The sum of '%d' is '%d'\n", -98, sumDigits(-98));
    System.out.printf("The sum of '%d' is '%d'\n", 9878651, sumDigits(9878651));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int sumDigits(int number) {
    int sum = 0;
    int n = number < 0 ? -number : number;
    
    while (n != 0) {
      sum += n % 10;
      n /= 10;
    }
    
    return sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
