package chapter6;

/**
 * Displays the conversions between feet and meters.
 */
public class Exercise6_9 {
  
  public static void main(String[] args) {
    displayTitle();
    System.out.println();
    displayBody();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double footToMeter(double foot) {
    return 0.305 * foot;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double meterToFoot(double meter) {
    return 3.279 * meter;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayTitle() {
    System.out.printf("%-10s\t%-15s\t|%15s\t%10s\n", "Feet", "Meters", "Meters", "Feet");
    for (int i = 0; i < 60; i++) System.out.print("-");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayBody() {
    for (double f = 1.0, m = 20.0; f <= 10.0; f++, m += 5.0) {
      displayFeetToMeter(f);
      System.out.printf("\t|");
      displayMeterToFeet(m);
      System.out.println();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayMeterToFeet(double meter) {
    System.out.printf("%15.1f\t%11.3f", meter, meterToFoot(meter));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayFeetToMeter(double foot) {
    System.out.printf("%-11.1f\t%-15.3f", foot, footToMeter(foot));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
