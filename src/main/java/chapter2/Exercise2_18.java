package chapter2;

/**
 * Prints a table that contains integers in columns a and b. The third column contains the result of the integer of
 * column a raised to the power of the integer in column b.
 */
public class Exercise2_18 {
  
  public static void main(String[] args) {
    System.out.printf("a\tb\tpow(a, b)\n");
    System.out.printf("1\t2\t%d\n", (int)Math.pow(1, 2));
    System.out.printf("2\t3\t%d\n", (int)Math.pow(2, 3));
    System.out.printf("3\t4\t%d\n", (int)Math.pow(3, 4));
    System.out.printf("4\t5\t%d\n", (int)Math.pow(4, 5));
    System.out.printf("5\t6\t%d\n", (int)Math.pow(5, 6));
  }
  
}
