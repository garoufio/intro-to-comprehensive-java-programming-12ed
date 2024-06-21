package chapter5;

/**
 * Finds the smallest number such that n^3 < 12000.
 */
public class Exercise5_13 {
  
  public static final int MAX_NUMBER = 12_000;
  
  public static void main(String[] args) {
    int number = 0;
    
    while (number * number * number <= MAX_NUMBER) {
      number++;
    }
    System.out.printf("The smallest number is '%d'\n", number - 1);
  }
  
}
