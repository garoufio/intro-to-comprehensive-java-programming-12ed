package chapter7;

import java.util.Scanner;

/**
 * (Pattern recognition: consecutive four equal numbers) Prompts the user to enter a series of integers and displays it
 * if the series contains four consecutive numbers with the same value. The program first prompts the user to enter the
 * input size—i.e., and then values in the series.
 */
public class Exercise7_30 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int size = readSize(input);
    int[] numbers = readIntegers(input, size);
    input.close();
    
    if (isConsecutiveFour(numbers)) {
      System.out.println("The list has consecutive fours");
    }
    else {
      System.out.println("The list has no consecutive fours");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isConsecutiveFour(int[] values) {
    boolean isEqual = true;
    
    for (int i = 0; i < values.length - 3; i++) {
      isEqual = true;
      for (int j = i + 1; j < i + 3; j++) {
        if (values[i] != values[j]) {
          isEqual = false;
          break;
        }
      }
    }
    return isEqual;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readIntegers(Scanner scanner, int size) {
    int[] numbers = new int[size];
    
    System.out.printf("Enter %d integer values: ", size);
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = scanner.nextInt();
    }
    return numbers;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readSize(Scanner scanner) {
    int size = 0;
    
    do {
      System.out.print("Enter the number of values: ");
      size = scanner.nextInt();
      
      if (size < 4) System.out.println("The number of values must be greater than 4");
    } while (size < 4);
    
    return size;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
