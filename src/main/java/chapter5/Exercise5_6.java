package chapter5;

/**
 * Converts miles to kilometers and kilometers to pounds. Finally, it displays the conversion.
 */
public class Exercise5_6 {
  
  public static final double MILE_TO_KILOMETER = 1.609;
  
  public static void main(String[] args) {
    System.out.printf("%-15s%15s\t|\t%-15s%15s\n", "Miles", "Kilometers", "Kilometers", "Miles");
    for (int i = 1, k = 20; i <= 10; i++, k += 5) {
      System.out.printf("%-15d%15.3f\t|\t%-15d%15.3f\n", i, i * MILE_TO_KILOMETER, k, k / MILE_TO_KILOMETER);
    }
  }
  
}
