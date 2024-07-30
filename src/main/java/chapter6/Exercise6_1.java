package chapter6;

/**
 * Displays the first 100 pentagonal numbers with 10 numbers on each line.
 */
public class Exercise6_1 {
  
  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      if (i != 0 && i % 10 == 0) System.out.println();
      
      System.out.printf("%7d ", getPentagonalNumber(i + 1));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getPentagonalNumber(int n) {
    return (n * (3 * n - 1)) / 2;
  }
  
}
