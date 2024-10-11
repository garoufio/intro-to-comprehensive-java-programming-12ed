package chapter7;

import java.util.Scanner;

/**
 * Prompts the user to enter 10 numbers and calculates and displays the average value.
 */
public class Exercise7_8 {
  
  public static final int MAX_NUMBERS = 10;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    int[] integers = readIntegers(input);
    System.out.println("The average of the integers array is " + average(integers));
    
    double[] doubles = readDoubles(input);
    input.close();
    System.out.println("The average of the double array is " + average(doubles));
    
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readIntegers(Scanner scanner) {
    int[] numbers = new int[MAX_NUMBERS];
    
    System.out.printf("Enter %d integer numbers: ", MAX_NUMBERS);
    for (int i = 0; i < MAX_NUMBERS; i++) {
      numbers[i] = scanner.nextInt();
    }
    return numbers;
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
  
  public static double average(int[] array) {
    int sum = 0;
    
    for (int number : array) {
      sum += number;
    }
    return (double)sum / array.length;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double average(double[] array) {
    double sum = 0;
    
    for (double number : array) {
      sum += number;
    }
    return sum / array.length;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
