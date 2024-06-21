package chapter5;

/**
 * Converts kilograms to pounds and pounds to kilograms. Finally, it displays the conversion.
 */
public class Exercise5_5 {
  
  public static final double KILOGRAM_TO_POUND = 2.2;
  
  public static void main(String[] args) {
    System.out.printf("%-15s%15s\t|\t%-15s%15s\n", "Kilograms", "Pounds", "Pounds", "Kilograms");
    for (int i = 1, p = 20; i < 200; i += 2, p += 5) {
      System.out.printf("%-15d%15.1f\t|\t%-15d%15.2f\n", i, i * KILOGRAM_TO_POUND, p, p / KILOGRAM_TO_POUND);
    }
  }
  
}
