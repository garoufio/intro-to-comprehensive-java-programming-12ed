package chapter5;

/**
 * It approximates the e and displays the result. The formula to approximate e is the following:
 * 1 + 1/1! + 1/2! + ... + 1/i!
 */
public class Exercise5_26 {
  
  public static void main(String[] args) {
    double e, item;
    
    for (int i = 1; i <= 20; i++) {
      e = 1;
      for (int j = 1; j <= i; j++) {
        item = 1;
        // compute factorial
        for (int k = j; k >= 2; k--) {
          item *= k;
        }
        // add factorial to e
        e += 1 / item;
      }
      System.out.printf("e for i '%d' is '%.16f'\n", i, e);
    }
    
    // Liang's solution
//    e = 1;
//    item = 1;
//    for (int i = 1; i <= 20; i++) {
//      item = item / i;
//      e += item;
//      System.out.printf("%s%.16f%s%d\n", "The e is ", e, " for i = ", i);
//    }
  }
  
}
