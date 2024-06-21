package chapter5;

/**
 * Converts kilograms to pounds and displays the conversion.
 */
public class Exercise5_3 {
  
  public static final double KILOGRAM_TO_POUND = 2.2;
  
  public static void main(String[] args) {
    System.out.printf("%-15s%15s\n", "Kilograms", "Pounds");
    for (int i = 1; i < 200; i += 2) {
      System.out.printf("%-15d%15.1f\n", i, i * KILOGRAM_TO_POUND);
    }
  }
  
}
