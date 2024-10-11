package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prompts the user to enter 10 integer values, and then sorts them using the bubble sort algorithm.
 */
public class Exercise7_18 {
  
  public static final int MAX_NUMBERS = 10;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] numbers = readIntegers(input);
    input.close();
    
    bubbleSort(numbers);
    System.out.println(Arrays.toString(numbers));
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
  
  public static void bubbleSort(int[] numbers) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < numbers.length - 1; i++) {
        if (numbers[i] > numbers[i + 1]) {
          int temp = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
