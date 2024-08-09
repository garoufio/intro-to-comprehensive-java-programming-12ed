package chapter6;

/**
 * Displays the conversions between Celsius and Fahrenheit degrees.
 */
public class Exercise6_8 {
  
  public static void main(String[] args) {
    displayTitle();
    System.out.println();
    displayBody();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double celsiusToFahrenheit(double celsius) {
    return (9.0 / 5) * celsius + 32;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double fahrenheitToCelsius(double fahrenheit) {
    return (5.0 / 9) * (fahrenheit - 32);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayTitle() {
    System.out.printf("%-10s\t%-15s\t|%15s\t%10s\n", "Celsius", "Fahrenheit", "Fahrenheit", "Celsius");
    for (int i = 0; i < 60; i++) System.out.print("-");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayBody() {
    for (double c = 40.0, f = 120.0; c >= 31.0; c--, f -= 10.0) {
      displayCelsiusToFahrenheit(c);
      System.out.printf("\t|");
      displayFahrenheitToCelsius(f);
      System.out.println();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayCelsiusToFahrenheit(double celsius) {
    System.out.printf("%-10.2f\t%-12.2f", celsius, celsiusToFahrenheit(celsius));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayFahrenheitToCelsius(double fahrenheit) {
    System.out.printf("%15.2f\t%10.2f", fahrenheit, fahrenheitToCelsius(fahrenheit));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
