package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prompts the user to enter 10 integer values, and then reverses and displays the array.
 */
public class Exercise7_12 {
  
  public static final int MAX_NUMBERS = 9;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] numbers = readIntegers(input);
    input.close();
    
    reverse(numbers);
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
  
  public static void reverse(int[] array) {
    int tmp;
    
    for (int start = 0, end = array.length - 1; start < array.length / 2; start++, end--) {
      tmp = array[start];
      array[start] = array[end];
      array[end] = tmp;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
