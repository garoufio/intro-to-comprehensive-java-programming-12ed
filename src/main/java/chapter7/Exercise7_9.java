package chapter7;

import java.util.Scanner;

/**
 * Prompts the user to enter 10 double numbers and finds and displays the smallest number.
 */
public class Exercise7_9 {
  
  public static final int MAX_NUMBERS = 10;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double[] numbers = readDoubles(input);
    input.close();
    
    System.out.println("The minimum number is " + min(numbers));
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
  
  public static double min(double[] array) {
    double minNumber = array[0];
    
    for (int i = 1; i < array.length; i++) {
      if (array[i] < minNumber) minNumber = array[i];
    }
    return minNumber;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
