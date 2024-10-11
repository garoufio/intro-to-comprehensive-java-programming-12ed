package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prompts the user to enter 10 integer numbers. Then the program eliminates the duplicates and displays the new
 * array.
 */
public class Exercise7_15 {
  
  public static final int MAX_NUMBERS = 10;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] numbers = readIntegers(input);
    input.close();
    
    int[] numbersNoDuplicates = eliminateDuplicates(numbers);
    System.out.printf("The distinct numbers are: %s\n", Arrays.toString(numbersNoDuplicates));
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
  
  public static int[] eliminateDuplicates(int[] list) {
    boolean isDuplicate = false;
    int index = 0;
    int[] nonDuplicates = new int[list.length];
    
    for (int n : list) {
      isDuplicate = false;
      for (int i = 0; i < nonDuplicates.length; i++) {
        if (n == nonDuplicates[i]) {
          isDuplicate = true;
          break;
        }
      }
      if (!isDuplicate) {
        nonDuplicates[index++] = n;
      }
    }
    return truncateArray(nonDuplicates, index);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] truncateArray(int[] list, int index) {
    return Arrays.copyOfRange(list, 0, index);
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
