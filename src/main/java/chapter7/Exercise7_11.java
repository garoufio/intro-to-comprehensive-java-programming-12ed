package chapter7;

import java.util.Scanner;

/**
 * Prompts the user to enter 10 double values and calculates and displays the mean and the deviation.
 */
public class Exercise7_11 {
  
  public static final int MAX_NUMBERS = 10;
  private static double meanValue;
  private static double deviationValue;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double[] numbers = readDoubles(input);
    input.close();
    
    meanValue = mean(numbers);
    deviationValue = deviation(numbers);
    
    System.out.printf("The mean is '%.2f'\nThe standard deviation is '%.2f'\n", meanValue, deviationValue);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[] readDoubles(Scanner scanner) {
    double[] numbers = new double[MAX_NUMBERS];
    
    System.out.printf("Enter %d double numbers: ", MAX_NUMBERS);
    for (int i = 0; i < MAX_NUMBERS; i++) {
      numbers[i] = scanner.nextDouble();
    }
    return numbers;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double deviation(double[] x) {
    if (x == null || x.length == 0) return 0.0;
    
    double sum = 0.0;
    
    for (int i = 0; i < x.length; i++) {
      sum += Math.pow(x[i] - meanValue, 2);
    }
    return Math.sqrt(sum / (x.length - 1));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double mean(double[] x) {
    if (x == null || x.length == 0) return 0.0;
    
    double sum = 0.0;
    
    for (double n : x) sum += n;
    
    return sum / x.length;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
