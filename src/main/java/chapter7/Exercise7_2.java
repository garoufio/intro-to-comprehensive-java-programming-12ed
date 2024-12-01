package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prompts the user to enter 10 integers and displays them in reverse order.
 */
public class Exercise7_2 {
  
  public static void main(String[] args) {
    int[] numbers;
    try (Scanner input = new Scanner(System.in)) {
      numbers = readIntegers(input);
      int[] reversedNumbers = reverseArray(numbers);
      System.out.println(Arrays.toString(reversedNumbers));
    }
    catch (Exception e) {
      System.err.println("Invalid input");
    }    
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readIntegers(Scanner scanner) {
    int[] numbers = new int[10];
    
    System.out.print("Enter 10 integers: ");
    for (int i = 0; i < 10; i++) {
      numbers[i] = scanner.nextInt();
    }
    
    return numbers;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] reverseArray(int[] array) {
    int[] reversedArray = new int[array.length];
    
    for (int i = array.length - 1; i >= 0; i--) {
      reversedArray[array.length - 1 - i] = array[i];
    }
    
    return reversedArray;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
