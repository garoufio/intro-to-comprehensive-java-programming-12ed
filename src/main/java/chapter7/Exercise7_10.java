package chapter7;

import java.util.Scanner;

/**
 * Prompts the user to enter 10 integers and finds and displays the index of the smallest element.
 */
public class Exercise7_10 {
  
  public static final int MAX_NUMBERS = 10;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] numbers = readIntegers(input);
    input.close();
    
    System.out.println("The index of the smallest element is: " + indexOfSmallestElement(numbers));
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
  
  public static int indexOfSmallestElement(int[] numbers) {
    int index = 0;
    int min = numbers[0];
    
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] < min) {
        min = numbers[i];
        index = i;
      }
    }
    return index;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
