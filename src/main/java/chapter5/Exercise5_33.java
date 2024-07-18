package chapter5;

/**
 * A positive integer is called a perfect number if it is equal to the sum of all of its positive divisors, excluding
 * itself. For example, 6 is the first perfect number because 6 = 3 + 2 + 1. The next is 28 = 14 + 7 + 4 + 2 + 1. There
 * are four perfect numbers < 10,000. The following program finds all these four numbers.
 */
public class Exercise5_33 {
  
  public static final int MAX_NUMBER = 10000;
  
  public static void main(String[] args) {
    int sum;
    for (int i = 2; i <= MAX_NUMBER; i++) {
      sum = 0;
      for (int j = i - 1; j > 0; j--) {
        if (i % j == 0) sum += j;
      }
      if (sum == i) System.out.printf("'%d' is a perfect number\n", i);
    }
  }
  
}