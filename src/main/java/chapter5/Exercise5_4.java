package chapter5;

/**
 * Converts miles to kilometers and displays the conversion.
 */
public class Exercise5_4 {
  
  public static final double MILE_TO_KILOMETER = 1.609;
  
  public static void main(String[] args) {
    System.out.printf("%-15s%15s\n", "Miles", "Kilometers");
    for (int i = 1; i <= 10; i++) {
      System.out.printf("%-15d%15.3f\n", i, i * MILE_TO_KILOMETER);
    }
  }
  
}
