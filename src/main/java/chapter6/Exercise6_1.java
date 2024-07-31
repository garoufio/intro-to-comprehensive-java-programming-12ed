package chapter6;

/**
 * Displays the first 100 pentagonal numbers with 10 numbers on each line.
 */
public class Exercise6_1 {
  
  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {
      System.out.printf("%7d", getPentagonalNumber(i));
      
      if (i % 10 == 0) System.out.println();
      else System.out.print(" ");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getPentagonalNumber(int n) {
    return (n * (3 * n - 1)) / 2;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
