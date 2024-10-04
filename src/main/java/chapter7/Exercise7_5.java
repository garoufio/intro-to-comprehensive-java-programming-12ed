package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prompts the user to enter 10 numbers and displays the number of distinct numbers and the distinct numbers in their
 * input order and separated by exactly one space.
 */
public class Exercise7_5 {
  
  public static final int TOTAL_NUMBERS = 10;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    int[] numbers = readIntegers(input);
    input.close();
    
    int[] distinct = getDistinctNumbers(numbers);
    System.out.println(Arrays.toString(distinct));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readIntegers(Scanner scanner) {
    int[] numbers = new int[TOTAL_NUMBERS];
    
    System.out.printf("Enter %d integer values: ", TOTAL_NUMBERS);
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = scanner.nextInt();
    }
    return numbers;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] truncateArray(int[] array) {
    int count = 0;
    for (int val : array) {
      if (val == 0) break;
      
      count++;
    }
    return Arrays.copyOf(array, count);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getDistinctNumbers(int[] array) {
    int[] distinctNumbers = new int[array.length];
    int distinctIndex = 0;
    boolean isFound;
    
    if (array.length > 0) {
      for (int i = 0; i < array.length; i++) {
        isFound = false;
        // linear search with key = array[i]
        for (int j = 0; j < array.length; j++) {
          if (distinctNumbers[j] == array[i]) {
            isFound = true;
            break;
          }
        }
        if (!isFound) distinctNumbers[distinctIndex++] = array[i];
      }
    }
    return truncateArray(distinctNumbers);
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
